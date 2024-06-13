// https://leetcode.com/problems/word-break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        Set<Integer> lenSet= new HashSet<>();
        for(String w : set){
            lenSet.add(w.length());
        }

        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;

        for(int i=1; i<=len; i++){
            for(int wLen : lenSet){
                if(i-1+wLen<=len){
                    String sub = s.substring(i-1, i-1+wLen);
                    if(dp[i-1] && set.contains( sub )){
                        dp[i-1+wLen]=true;
                    }
                }
            }
        }


        return dp[len];
    }
}