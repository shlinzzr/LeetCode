// https://leetcode.com/problems/maximum-number-of-points-with-cost

class Solution {
    public long maxPoints(int[][] points) {

        int h = points.length;
        int w = points[0].length;

        long[] dp = new long[w];
        for(int j=0; j<w; j++){
            dp[j] = (long)points[0][j];
        } 

        for(int i=1; i<h; i++){

            long[] tmp = new long[w];

            long rollingMax = Integer.MIN_VALUE;
            for(int j=0; j<w; j++){
                rollingMax = Math.max(rollingMax, dp[j]+j);
                tmp[j] = Math.max(tmp[j], rollingMax+points[i][j]-j);
            }

            rollingMax = Integer.MIN_VALUE;
            for(int j=w-1; j>=0; j--){
                rollingMax = Math.max(rollingMax, dp[j]-j);
                tmp[j] = Math.max(tmp[j], rollingMax+points[i][j]+j);
            }
            dp=tmp;


/*

dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + points[i][j] - Math.abs(j-k))

=> dp[i][j] = Math.max(dp[i-1][k] + k) + points[i][j] -j; k=0,1,2,3 ...~j  ,    if(k>=j)
   dp[i][j] = Math.max(dp[i-1][k] - k) + points[i][j] +j; k=j, j+1, ... w-1.    if(j>=k)


                // tmp[j] = dp[j] + (long)points[i][j];
                // dp[j] = dp[j] + points[i][j];

                // for(int k=j; k<w; k++){
                //     tmp[j] = Math.max(tmp[j], dp[k]+(long)points[i][j] - Math.abs(k-j));
                //     tmp[k] = Math.max(tmp[k], dp[j]+(long)points[i][k] - Math.abs(k-j));
                // }
            // }
        }

        long res = Integer.MIN_VALUE;
        for(int j=0; j<w; j++){
            res = Math.max(res, dp[j]);
        }

        return res;


    }
}
/*
[[0,3,0,4,2]
,[5,4,2,4,1]
,[5,0,0,5,1]
,[2,0,1,0,3]]

*/