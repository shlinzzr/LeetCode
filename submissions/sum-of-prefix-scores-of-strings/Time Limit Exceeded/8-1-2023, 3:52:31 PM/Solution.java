// https://leetcode.com/problems/sum-of-prefix-scores-of-strings

class Solution {
    public int[] sumPrefixScores(String[] words) {
        int len = words.length;
        
        int[] res = new int[len];
         
        for(int i=0; i<len; i++){
            
            String w = words[i];
            
            int cnt= 0 ;
            for(int j=1; j<=w.length(); j++){
                
                String sub = w.substring(0, j);
                
                for(String ww : words){
                    if(ww.startsWith(sub))
                        cnt++;
                }
            }
            
            res[i]=cnt;
            
            
        }
        return res;
        
    }
}