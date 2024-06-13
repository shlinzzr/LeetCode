// https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int h= mat.length;
        int w = mat[0].length;
        int[][] presum = new int[h+1][w+1];
        int res = 0 ;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                presum[i+1][j+1]=mat[i][j]+ presum[i][j+1] + presum[i+1][j] - presum[i][j];

                int maxEdge = 1+Math.min(i, j);

                for(int e = maxEdge; e>res; e--){

                    int sqSum = presum[i+1][j+1]
                              - presum[i+1-e][j+1]
                              - presum[i+1][j+1-e]
                              + presum[i+1-e][j+1-e];
                    if(sqSum<=threshold){
                        res = Math.max(res, e);
                    }else
                        break;

                }
            }
        }

        return res;


    }
}