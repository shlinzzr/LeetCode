// https://leetcode.com/problems/word-break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        int len = s.length();

        boolean[] dp = new boolean[len+1]; // 是否可以組成s 當看到前i個字母
        dp[0] = true;

        // 0 1 2 3 4 5 6 7 8
        //   l e e t c o d e


        for(int i=1; i<=len; i++){

            for(int j=0; j<i; j++){
                String sub = s.substring(j, i);
                if(set.contains(sub) && dp[j]){
                    dp[i] = true;
                }
            }
        }

        return dp[len];
        
    }
}