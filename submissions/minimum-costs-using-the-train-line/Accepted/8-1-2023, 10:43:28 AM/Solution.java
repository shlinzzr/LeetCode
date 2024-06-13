// https://leetcode.com/problems/minimum-costs-using-the-train-line

class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int len = regular.length;
        
        
//         // bottom-up dp]
//         long[] res = new long[len];
//         long[][] dp = new long[len+1][2];
//         dp[0][1] = 0;             // 1: regular
//         dp[0][0] = expressCost;   // 0: express
//         // Need to spend expressCost, as we start from the regular lane initially.
        
//         for (int i=1; i<len+1; i++) {
//             // Use the regular lane; no extra cost to switch to the express lane.
//             dp[i][1] = regular[i-1] + Math.min(dp[i-1][1], dp[i-1][0]);
//             // Use express lane; add extra cost if the previously regular lane was used.
//             dp[i][0] = express[i-1] + Math.min(expressCost + dp[i - 1][1], dp[i - 1][0]);
            
//             res[i-1] = Math.min(dp[i][0], dp[i][1]);
//         }
//         return res; 
        
        
        
        // top-down dp
        long[][] dp = new long[len][2];  //1:regular, 0:express
        for (int i=0; i<len; i++) {
            Arrays.fill(dp[i], -1); // init
        }
        
        // start from last stop, 1: regular lane
        solve(len-1, 1, dp, regular, express, expressCost);
        
        long[] ans = new long[len];
        // Store cost for each stop.
        for (int i = 0 ; i < len; i++) {
            ans[i] = dp[i][1];
        }
        
        return ans;
    }
    
    
    private long solve(int i, int lane, long[][] dp, int[] regular, int[] express, int expressCost) {
       
        if (i < 0)  return 0;  // If all stops are covered, return 0.
        if (dp[i][lane] != -1)  return dp[i][lane];
        
        // Use the regular lane; no extra cost to switch lanes if required.
        long regularLane = regular[i] + solve(i-1, 1, dp, regular, express, expressCost);
        // Use express lane; add expressCost if the previously regular lane was used.
        long expressLane = (lane == 1 ? expressCost : 0) + express[i] 
                                                    + solve(i - 1, 0, dp, regular, express, expressCost);

        return dp[i][lane] = Math.min(regularLane, expressLane);
    }
}