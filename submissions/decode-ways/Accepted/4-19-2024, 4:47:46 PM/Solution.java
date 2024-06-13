// https://leetcode.com/problems/decode-ways

class Solution {
    public int numDecodings(String s) {
        int len = s.length();

        if(len==0) return 0; 

        int[] dp = new int[len+1];
        dp[len] = 1;
        dp[len-1] = s.charAt(len-1) !='0' ? 1 : 0;

        for(int i=len-2; i>=0; i--){
            if(s.charAt(i)=='0')   continue;

            dp[i] = dp[i+1];
            if(Integer.parseInt(s.substring(i, i+2))<=26){
                dp[i]+=dp[i+2];
            } 
        }

        return dp[0];
    }
}