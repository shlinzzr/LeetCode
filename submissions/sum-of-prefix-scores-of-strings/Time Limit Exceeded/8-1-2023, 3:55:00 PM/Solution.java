// https://leetcode.com/problems/sum-of-prefix-scores-of-strings

class Solution {
    public int[] sumPrefixScores(String[] words) {
        int len = words.length;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        
        int[] res = new int[len];
         
        for(int i=0; i<len; i++){
            
            String w = words[i];
            
            int cnt= 0 ;
            for(int j=1; j<=w.length(); j++){
                
                String sub = w.substring(0, j);
                
                if(map.containsKey(sub)){
                    cnt += map.get(sub);
                     continue;
                }
                int val = 0;
                for(String ww : words){
                    if(ww.startsWith(sub))
                        val++;
                }
                map.put(sub, val);
                cnt+=val;
                
                
            }
            
            res[i]=cnt;
            
            
        }
        return res;
        
    }
}