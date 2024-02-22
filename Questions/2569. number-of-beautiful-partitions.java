// https://leetcode.com/problems/number-of-beautiful-partitions

class Solution {
    public int beautifulPartitions(String s, int K, int minLength) {
        int len = s.length();
        s = "#"+s;
        
        int M = (int)1e9+7;
        
        long[][] dp =  new long[len+1][K+1];
        
        dp[0][0] = 1;
        for (int j=1; j<=K; j++)
        {
            long sum = 0;
            for (int i=1; i<=len; i++)            
            {    
                if (i-minLength>=0 && !isprime(s.charAt(i-minLength)) && isprime(s.charAt(i-minLength+1)))
                {
                    sum += dp[i-minLength][j-1];
                    sum %= M;
                }
                if (!isprime(s.charAt(i))) {
                    dp[i][j] = sum;                    
                }                
            }
        }
        return (int)dp[len][K];
    }
                    
    private boolean isprime(char ch)
    {
        return ch == '2' || ch == '3' || ch == '5' || ch == '7';
    }     
    
}