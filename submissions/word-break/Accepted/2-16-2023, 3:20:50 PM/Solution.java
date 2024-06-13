// https://leetcode.com/problems/word-break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        
        // first sol : dp
        // enhance_1: only find until wordDictMaxLen;
        // enhance_2: use hashset to replace list
        
        Set<String> set = new HashSet<>();
        int wordDictMaxLen = 0;
        for(String w : wordDict){
            set.add(w);
            wordDictMaxLen = Math.max(wordDictMaxLen, w.length());
        }
        
        
        boolean[] dp = new boolean[len+1]; //0~len
        dp[0]=true; //組成空字串的方式always true
        // find dp[len];
        for(int ed=0; ed<=len; ed++){
            for(int st=0; st<ed; st++){
                
                if(ed-st>wordDictMaxLen)
                    continue;
                
                if(dp[st] && set.contains(s.substring(st, ed))){
                    dp[ed]=true;
                }
            }
        }
        
        return dp[len];
        
        
        
        
    }
}