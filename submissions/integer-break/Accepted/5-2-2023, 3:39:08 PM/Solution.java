// https://leetcode.com/problems/integer-break

class Solution {
    public int integerBreak(int n) {
        
        //huifeng wodage https://www.youtube.com/watch?v=BhxOcwiOTCM&t=904s
        
        
        if(n==2) return 1;
        if(n==3) return 2;
        
        // if(n==4) return 4 =>  4==2+2, ans==2*2=4;
        // if(n==5) return 6 =>  5==3+2, ans==3*2=6;
        // if(n==6) return 9 =>  6==3+3, ans==3*3=9;

        
        int[] dp = new int[n+1];
        dp[2]=2;
        dp[3]=3;
        for(int i=4; i<=n; i++){
            for(int j=0; j<=i/2; j++){
                dp[i] = Math.max(dp[i], dp[j]*dp[i-j]);
            }
        }
        
        return dp[n];
        
        
        /*
        int product=1;
        while(n>4){ // 6>4
            product*=3; //prod=3
            n-=3; //n=3
        }
        product *= n; //prod = 3*3=9
        
        
        
        return product;
        */
        
    }
}