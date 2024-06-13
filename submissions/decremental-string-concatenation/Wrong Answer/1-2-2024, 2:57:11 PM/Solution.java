// https://leetcode.com/problems/decremental-string-concatenation

class Solution {
    public int minimizeConcatenatedLength(String[] words) {
        int len = words.length;

        int[][][] dp = new int[1<<len][26][26];

        String w = words[0];
        int state = (1<<0);

        return w.length() + dfs(words, 1, w.charAt(0)-'a', w.charAt(w.length()-1)-'a', dp, 1);
    }

    private int dfs(String[] words, int idx, int st, int ed, int[][][] dp, int state){
        if(idx==words.length) return 0;

        if( dp[state][st][ed]!=0) return dp[state][st][ed];

        int min = Integer.MAX_VALUE/2;
        for(int i=0; i<words.length; i++){
            if((state & (1<<i))==0 ){
                String w = words[i];
                int newState = state | (1<<i);
                if(state==0){
                    int nextst = w.charAt(0)-'a';
                    int nexted = w.charAt(w.length()-1)-'a';
                    min = Math.min(min, w.length() + dfs(words, idx+1, nextst, nexted, dp, newState));

                }else{
                    boolean prevcurr = (char)(ed+'a') == w.charAt(0) ;
                    boolean currprev = (char)(st+'a') == w.charAt(w.length()-1);
                    if(prevcurr){
                        int nexted = w.charAt(w.length()-1)-'a';
                        min = Math.min(min, w.length()-1 + dfs(words, idx+1, st, nexted, dp, newState));
                    }
                    if (currprev){
                        int nextst = w.charAt(0)-'a';
                        min = Math.min(min, w.length()-1 + dfs(words, idx+1, nextst, ed, dp, newState));
                    }

                    // if(!currprev && !prevcurr){
                        min = Math.min(min, w.length() + dfs(words, idx+1, st, ed, dp, newState));
                        min = Math.min(min, w.length() + dfs(words, idx+1, ed, st, dp, newState));
                    // }
                }
            }
        }

        dp[state][st][ed]=min;
        return min;

    }
}