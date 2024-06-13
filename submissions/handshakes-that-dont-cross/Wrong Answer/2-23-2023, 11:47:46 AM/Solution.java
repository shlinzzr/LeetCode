// https://leetcode.com/problems/handshakes-that-dont-cross

class Solution {
    public int numberOfWays(int n) {
        long mod = (long)1e9 + 7;
        long[] dp = new long[n +1];
        dp[0]=1;
        dp[2]=1;
        for(int i=4; i<=n; i+=2){
            for(int left=0; left<i; left+=2){
                int right=i-left-2;
                dp[i]+= (dp[left] * dp[right])% mod;;
            }
        }
            
        
        return (int)(dp[n]);
    }
}