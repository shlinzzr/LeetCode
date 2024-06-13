// https://leetcode.com/problems/number-of-matching-subsequences

class Solution {
    
    HashSet<String> bool = new HashSet<>();
    public int numMatchingSubseq(String s, String[] words) {
        int cnt = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, map.getOrDefault(w,0)+1);
        }
        
        
        for(String w : map.keySet()){
            
            if(bool.contains(w) || isSub(s, w))
                cnt+=map.get(w);
        }
        
        return cnt;
        
        
    }
    
    private boolean  isSub(String a, String b){
        
        
        // find b is subseq of a
        
        int len = a.length();
        int idx = 0;
        
        for(int i=0; i<len; i++){
            
            if(a.charAt(i)==b.charAt(idx)){
                idx++;
            }
            
           if(idx==b.length()){
               bool.add(a);
               return true;
           }
                
        }
        
        return false;
        
    }
    
}