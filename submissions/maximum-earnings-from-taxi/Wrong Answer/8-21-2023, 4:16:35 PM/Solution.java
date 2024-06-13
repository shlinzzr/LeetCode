// https://leetcode.com/problems/maximum-earnings-from-taxi

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        int len = rides.length;
        int[] dp = new int[len+1]; // max tips at i ride
        
        Arrays.sort(rides, (a,b)-> a[1]-b[1]);
        
        dp[0] = (rides[0][1]-rides[0][0]) + rides[0][2];
        // dp[0] = rides[0][2];
        
        
        
        for(int i=1; i<=len; i++){
            dp[i] = Math.max(dp[i-1], rides[i-1][1]-rides[i-1][0] +rides[i-1][2]);
            
            for(int j=i-1; j>0; j--){
                
                if(rides[j-1][1]<=rides[i-1][0]){
                    dp[i] = Math.max(dp[i],  dp[j] + (rides[i-1][1]-rides[i-1][0]+rides[i-1][2]));
                    break;
                }
            }
        }
        
        return dp[len];
        
        
    }
}