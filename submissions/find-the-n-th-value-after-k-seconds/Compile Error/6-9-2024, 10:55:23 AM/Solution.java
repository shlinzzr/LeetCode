// https://leetcode.com/problems/find-the-n-th-value-after-k-seconds

class Solution {
    public int valueAfterKSeconds(int n, int k) {
        
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        
        long res = 0;
        int M = (int) 1e9+7;
        
        
        while(k-->0){
            long sum = 0L;
            
            
            long[] next = new long[n];
            for(int i=0; i<len; i++){
                
                for(int j=0; j<=i; j++){
                    sum = (sum + dp[j])%M;
                }
                
                next[i] = sum;
            
            }
            
            dp = next;
            
            
//             for(int i=n-1; i>=0;i--){
//                 sum = (sum + dp[i]);
//                 // sum%=M;
//             }
            
//             long[] next = new long[n];
            
//             for(int i=n-1; i>=0;i--){
//                 next[i] = i==n-1? sum : next[i+1]-dp[i+1];   
//                 // next[i]%=M;
                
//             }
//             dp = next;
                
            
        }
        
        return (int) (dp[n-1]%M);
        
    }
}