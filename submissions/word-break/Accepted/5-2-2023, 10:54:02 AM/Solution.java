// https://leetcode.com/problems/word-break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        
        // first sol : dp
        // enhance_1: only find until wordDictMaxLen;
        // enhance_2: use hashset to replace list
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        
        HashSet<String> set = new HashSet<>(wordDict);
        
        
        for(int ed=0; ed<=len;ed++){
            
            for(int st=0; st<ed; st++){
                
                
                if(dp[st] && set.contains(s.substring(st, ed)))
                    dp[ed] = true;
            }
            
        }
        
        
        
        
        
        return dp[len];
        
        
        
        
    }
}