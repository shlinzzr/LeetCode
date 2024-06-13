// https://leetcode.com/problems/integer-break

class Solution {
    public int integerBreak(int n) {
        // dp 
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1; //組成2的max product
        
        if(n==2){
            return 1;
        }
        
        if(n==3){
            return 2;
        }
        
        if(n==4)
            return 4;
        
        if(n==5)
            return 6;
        
        int product=1;
        
        while(n>3){
            product*=3;
            n-=3;
        }
        
        product *= n;
        
        return product;
        
        
        
        
        
//      
//         for(int i=2; i<=n; i++){
            
//             for(int j=1; j<=i/2; j++){
//                 dp[i] = Math.max(dp[i], Math.max(j, dp[j])* Math.max(i-j, dp[i-j]));
//             }
            
//         }
        
//         return dp[n];
    }
}