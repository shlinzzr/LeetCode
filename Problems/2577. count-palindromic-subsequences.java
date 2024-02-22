// https://leetcode.com/problems/count-palindromic-subsequences

class Solution {
    
    //https://www.youtube.com/watch?v=vI8-063NjRY
    public int countPalindromes(String s) {
        
        int n = s.length();
        
        int M = (int)1e9+7;
        
        long[][][] dp1 = new long[n+1][10][10];
        long[][] pre = new long[n+1][10];
        
        long[][][] dp2 = new long[n+1][10][10];
        long[][] post = new long[n+1][10];
        
        
        for (int j=0; j<=9; j++)
        {
            int sum = 0;
            for (int i=1; i<=n; i++)
            {
               if(s.charAt(i-1)-'0'==j)
                    sum++;
               pre[i][j] = sum;
            }
        }
        
        
        
        for (int j=0; j<=9; j++)
        {
            int sum = 0;
            for (int i=n; i>=1; i--)
            {
                if(s.charAt(i-1)-'0'==j)
                    sum++;
                post[i][j] = sum;
            }
        }        
        
        
        
        for (int i=2; i<=n; i++){
            for (int j=0; j<=9; j++){
                for (int k=0; k<=9; k++){
                    dp1[i][j][k] = dp1[i-1][j][k];                    
                    if(s.charAt(i-1)-'0'==k)             
                        dp1[i][j][k] = (dp1[i][j][k] + pre[i-1][j]) % M;
                }       
            }
        }
        
        
        
        
        for (int i=n-1; i>=1; i--){
            for (int j=0; j<=9; j++) {        
                for (int k=0; k<=9; k++){
                    dp2[i][j][k] = dp2[i+1][j][k];
                    if(s.charAt(i-1)-'0'==k)                        
                        dp2[i][j][k] = (dp2[i][j][k] + post[i+1][j]) % M;                    
                }
            }
        }
        
        
        int ret =0;
        for (int i=3; i<=n-2; i++){
            for (int j=0; j<=9; j++){
                for (int k=0; k<=9; k++){
                    ret += (dp1[i-1][j][k] * dp2[i+1][j][k] )% M;
                    ret %= M;
                }
            }
        }
        
        return ret%M;
        
        
        /*
        a. dp[i][j][k]  += dp[i-1][j][k]
        b. if(s[i]==k){
            dp[i][j][k]  += pre[i-1][j]
        }
        
        
        
        */
        
    }
      
}