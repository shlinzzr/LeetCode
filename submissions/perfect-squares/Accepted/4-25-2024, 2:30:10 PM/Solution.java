// https://leetcode.com/problems/perfect-squares

class Solution {
    public int numSquares(int n) {
        
        
        int[] dp = new int[n+1]; // least num of perfect sq sum to n when meet n
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] =1;
        
        for(int i=1; i<=n; i++){
            
            for(int j=(int)Math.sqrt(i); j>0; j--){
                
                if(j*j==i) dp[i] = 1;
                else{
                    dp[i] =  Math.min(dp[i],  dp[j*j] + dp[i-j*j]);
                }
            }
            
        }
        
        return dp[n];
        
        
        
        
        
        
        
        
        
        
//         int res= 0 ;
//         while(n>0){
//             for(int i=(int)Math.sqrt(n); i>0 && n>0; i--){
//                 n-= i*i;
//                 res++;
//                 i=(int)Math.sqrt(n);
//             }
//         }
//         return res;
        
    }
}