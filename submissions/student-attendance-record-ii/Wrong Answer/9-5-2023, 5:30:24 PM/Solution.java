// https://leetcode.com/problems/student-attendance-record-ii

class Solution {
    
    int M = (int) 1e9+7;
    
    public int checkRecord(int n) {
        
        //https://www.youtube.com/watch?v=CYmxU6v6bGY
        
        // A, L, P
       // dp[i] with tatal combination with P and L
        
        // 1. without A
        // with P 
        // dp[i] = dp[i-1];
        
        // with L ...PLLL
        //          ^ i-4
        // dp[i] = dp[i-1] - dp[i-4]
        
        // 2. with A
        //with A
        // 1......n,  'A' is at i, => i-1, A, n-i
        
        
        
        // dp[i] = dp[i-1] * dp[n-i]
        
        int[] dp = new int[n<=3 ? 4 : n+1];
        dp[0] = 1;
        dp[1] = 2; // L, P
        dp[2] = 4; // LP, PL, LL, PP
        dp[3] = 7;   // 2^3==8 - 'LLL' ==7
        
        for(int i=4; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-1] - dp[i-4]+M)%M;
        }
        
        long sum = dp[n];
        for(int i=1; i<=n; i++){
            sum += (dp[i-1] * dp[n-i])%M;
        }
        
        return (int) (sum%M);
        
        
    }
}