// https://leetcode.com/problems/maximum-number-of-points-with-cost

class Solution {
    public long maxPoints(int[][] points) {

        int h = points.length;
        int w = points[0].length;

        long[] dp = new long[w];
        for(int j=0; j<w; j++){
            dp[j] = (long)points[0][j];
              System.out.print(dp[j]+",");
        }   System.out.println();

        for(int i=1; i<h; i++){

            long[] tmp = new long[w];


            for(int j=0; j<w; j++){
                tmp[j] = dp[j] + (long)points[i][j];
                // dp[j] = dp[j] + points[i][j];

                for(int k=j+1; k<w; k++){
                    tmp[j] = Math.max(tmp[j], dp[k]+(long)points[i][j] - Math.abs(k-j));
                }
            }



            dp = tmp;
            for(int j=0; j<w; j++){
                System.out.print(dp[j]+",");
            }
            System.out.println();
        }

        long res = 0;
        for(int j=0; j<w; j++){
            res = Math.max(res, dp[j]);
        }

        return res;


    }
}