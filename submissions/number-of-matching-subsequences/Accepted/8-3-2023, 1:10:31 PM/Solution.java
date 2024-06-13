// https://leetcode.com/problems/number-of-matching-subsequences

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int len = s.length();
        
         Map<String,Integer> map = new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        
        
        
        int cnt = 0;
        
        for(String w : map.keySet()){
            
            if(w.length()==0){
                cnt++;
                continue;
            }
            
            int j=0;
            for(int i=0; i<len; i++){
                //System.out.println()
                if(s.charAt(i)==w.charAt(j))
                    j++;
                
                if(j==w.length()){
                    cnt+= map.get(w);
                    break;
                }
            }
            
        }
        return cnt;
    }
}