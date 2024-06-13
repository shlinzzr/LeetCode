// https://leetcode.com/problems/longest-string-chain

class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, (a,b)->a.length()-b.length());
        
        HashMap<String, Integer> map = new HashMap<>();
        
        
        int len = words.length;
        int res = 0;
//         int dp = new int[len+1];
//         Arrays.fill(dp,1);
//         dp[0]=0;
//         dp[1]=1;
        
        
        for(String w : words){
            
            map.put(w, 1);
            
            
            
            for(int j=0; j<w.length(); j++){
                
                StringBuilder sb = new StringBuilder(w);
                String next = sb.deleteCharAt(j).toString();
                if(map.containsKey(next) && map.get(next)+1 > map.get(w))
                    map.put(w, map.get(next)+1);        
                
            }
            
             res = Math.max(res, map.get(w));       
        }
        
        return res;
        
    }
}