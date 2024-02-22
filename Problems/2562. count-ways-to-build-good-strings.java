// https://leetcode.com/problems/count-ways-to-build-good-strings

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
       
        int M = (int) 1e9+7;
        
        int[] dp = new int[high+1];
        dp[0]=1;
        
        for(int i=1; i<=high; i++){
            
            if(i-zero>=0)
                dp[i] = (dp[i] + dp[i-zero]) % M;
            
            if(i-one>=0)
                dp[i] = (dp[i] + dp[i-one]) % M;
        }
        
        
        int ans=0;
        for(int i=low; i<=high; i++){
            ans = (ans + dp[i]) % M;
        }
        
        return ans;
        
    }
    
    
}