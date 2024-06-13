// https://leetcode.com/problems/paint-house-ii

class Solution {
    public int minCostII(int[][] costs) {
        int len = costs.length;
        int k = costs[0].length;

        int[] dp  = new int[k];

        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;   
        int lastIdx=-1;
        for(int i=0; i<k; i++){
            dp[i] = costs[0][i];

            if(dp[i]<min){
                min = dp[i];
                lastIdx=i;
            }else{
                min2 = dp[i];
            }

        }

        
        
        
        for(int i=1; i<len; i++){
            // min = Integer.MAX_VALUE;
            int[] tmp = new int[k];
            System.out.println("lastIdx="+lastIdx);
            // System.out.println("lastIdx="+lastIdx);
        
            int idx=0, idx2=0;
            for(int j=0; j<k; j++){
                if(i==0 || j!=lastIdx){
                    if(dp[j]<min){
                        min = dp[j];
                        idx = j;
                    }

                    else if( dp[j]<min2){
                        min2 = dp[j];                        
                        idx2 = j;
                    }

                    
                    tmp[j] = costs[i][j] + min;
                }else{
                    tmp[j] = costs[i][j] + min2;
                    System.out.println("min2="+min2);
                }
                System.out.println("min="+min);
                System.out.println("idx="+idx);
            }
            lastIdx = idx;
            dp= tmp;
            for(int j=0; j<k; j++){
                 dp[j]= tmp[j];
                System.out.println(tmp[j]);
            }

        }
        int res = Integer.MAX_VALUE;
        for(int j=0; j<k; j++){
            res = Math.min(res, dp[j]);
        }

        return res;

    }
}