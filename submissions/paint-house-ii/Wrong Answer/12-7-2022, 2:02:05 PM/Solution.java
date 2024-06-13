// https://leetcode.com/problems/paint-house-ii

class Solution {
    public int minCostII(int[][] costs) {
        int len = costs.length;
        int k = costs[0].length;

        int[] dp  = new int[k];

        for(int i=0; i<k; i++){
            dp[i] = costs[0][i];
        }

        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int lastIdx=-1;
        for(int i=0; i<len; i++){
            
            int[] tmp = new int[k];
            
        
            int idx=0;
            for(int j=0; j<k; j++){
                if(i==0 || j!=lastIdx){
                    if(dp[j]<min){
                        min = dp[j];
                        idx = j;
                    }

                    else if( dp[j]<min2){
                        min2 = dp[j];                        
                    }

                    
                    tmp[j] = costs[i][j] + min;
                }else{
                    tmp[j] = costs[i][j] + min2;
                }
            }
            lastIdx = idx;
            dp= tmp;
            for(int j=0; j<k; j++){
                 dp[j]= tmp[j];
            }

        }
        int res = Integer.MAX_VALUE;
        for(int j=0; j<k; j++){
            res = Math.min(res, dp[j]);
        }

        return res;

    }
}