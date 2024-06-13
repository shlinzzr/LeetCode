// https://leetcode.com/problems/decremental-string-concatenation

class Solution {
     Integer[][][] dp;
    public int minimizeConcatenatedLength(String[] words) {
        int len = words.length;
        // int[][][] dp = new int[len][26][26];
         dp= new Integer[words.length + 1][27][27];
        String w = words[0];
        return w.length() + dfs(words, 1, w.charAt(0)-'a', w.charAt(w.length()-1)-'a');
    }

    private int dfs(String[] words, int idx, int st, int ed){
        if(idx==words.length) return 0;
        int min = Integer.MAX_VALUE/2;
        String w = words[idx];
        int a = w.charAt(0)-'a';
        int b = w.charAt(w.length()-1)-'a';

        if(dp[idx][st][ed]!=null) return dp[idx][st][ed];


        if(ed==a){
            min = Math.min(min, w.length()-1 + dfs(words, idx+1, st, b));
        }else
            min = Math.min(min, w.length() + dfs(words, idx+1, st, b));

        if(st==b){
            min = Math.min(min, w.length()-1 + dfs(words, idx+1, a, ed));
        }else{
            min = Math.min(min, w.length() + dfs(words, idx+1, a, ed));
        }

        dp[idx][st][ed] = min;
        return min;
    }
}