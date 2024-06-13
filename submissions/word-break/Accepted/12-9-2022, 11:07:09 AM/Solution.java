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
            wordDictMaxLen = Math.max(wordDictMaxLen, w.length());
            set.add(w);
        }
        
        
        boolean[] dp = new boolean[len+1]; //0~len
        dp[0]=true; //組成空字串的方式always true
        // find dp[len];
        for(int i=0; i<=len; i++){
            for(int j=0; j<i; j++){
                
                if(i-j>wordDictMaxLen)
                    continue;
                
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i]=true;
                }
            }
        }
        
        return dp[len];
        
        
        
        
    }
}