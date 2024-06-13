// https://leetcode.com/problems/word-break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        
        // first sol : dp
        boolean[] dp = new boolean[len+1]; //0~len
        dp[0]=true; //組成空字串的方式always true
        // find dp[len];
        
        for(int i=0; i<=len; i++){
            for(int j=0; j<i; j++){
                
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i]=true;
                }
            }
        }
        
        return dp[len];
        
        
        
        
    }
}