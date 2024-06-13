// https://leetcode.com/problems/decremental-string-concatenation

class Solution {
    public int minimizeConcatenatedLength(String[] words) {
        int len = words.length;

        int[][] dp = new int[1<<len][len];

        return dfs(words, 0, -1, dp, 0);

    }

    private int dfs(String[] words, int idx, int prev, int[][] dp, int state){
        if(idx==words.length) return 0;

        if(prev!=-1 && dp[state][prev]!=0) return dp[state][prev];

        int min = Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){
            if((state & (1<<i))==0){
                String w = words[i];
                int newState = state | (1<<i);
                if(prev==-1){
                    min = Math.min(min, w.length() + dfs(words, idx+1, i, dp, newState));

                }else{
                    if(words[prev].charAt(words[prev].length()-1) == w.charAt(0)){
                        min = Math.min(min, w.length()-1 + dfs(words, idx+1, i, dp, newState));
                    }else{
                        min = Math.min(min, w.length() + dfs(words, idx+1, i, dp, newState));
                    }
                }
            }
        }

        if(prev!=-1)dp[state][prev]=min;
        return min;

    }
}