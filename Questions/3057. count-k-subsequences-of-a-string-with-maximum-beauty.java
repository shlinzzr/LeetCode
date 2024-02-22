// https://leetcode.com/problems/count-k-subsequences-of-a-string-with-maximum-beauty

class Solution {
    int k;
    long global = 0;
    int beauty = 0;
    int M = (int) 1e9+7;
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        
        this.k=k;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for(int i=0; i<len; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        
        if(map.size()<k) return 0;
        
        List<Integer> list = new ArrayList<>();
        for(int v : map.values()){
            list.add(v);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(int i=0; i<k; i++){
            beauty+=list.get(i);
        }
        
        dfs(0, 0, 0, 1L, list);
        
        return (int)global;
        
        
    }
    
    private void dfs (int curPos, int picked, int curBeauty, long res , List<Integer> list){
        
        if(picked>k)  return;
        if(curBeauty>beauty) return;
         
        if (curBeauty == beauty && picked == k) {                     
            global = (global+res)%M;
            return;
        }
        
        int acc = 0;
        for(int i=curPos; i<list.size(); i++){
            acc+=list.get(i);
        }
        
        
        if (curBeauty + acc < beauty) return;
        
        
        for(int i=curPos; i<list.size(); i++){
            
            dfs(i+1, picked+1, curBeauty+list.get(i), res*list.get(i)%M, list);
            
            
        }
        
        
    }
}