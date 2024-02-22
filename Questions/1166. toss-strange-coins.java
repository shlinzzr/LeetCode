// https://leetcode.com/problems/toss-strange-coins

class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        
        int len = prob.length;
        
        
        double[] dp = new double[target + 1];
        dp[0] = 1.0;
        
        for (int i = 0; i<len; i++){
            for (int k = Math.min(i + 1, target); k >= 0; --k){
                dp[k] = (k > 0 ? dp[k - 1] : 0) * prob[i] + dp[k] * (1 - prob[i]);
            }
        }
                
        return dp[target];
        
    }
}