// https://leetcode.com/problems/fibonacci-number

class Solution {
//     public int fib(int n) {
//         int[] dp = new int[n+1];
//         dp[0]=0;
//         dp[1]=1;
        
//         for(int i=1; i<n;i++){
//             dp[i+1]=dp[i] + dp[i-1];
//         }
        
//         return dp[n];
//     }
    
    
     public int fib(int n) {
         
         int a =0;
         int b =1;
         int c =0;
         for(int i=0; i<n; i++){
             c=a+b;
             a=b;
             b=c;
         }
         
         return a;
         
         
     }
}