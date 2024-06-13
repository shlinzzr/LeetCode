// https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int res = 0;
        int h = grid.length;
        int w = grid[0].length;
        int[][] presum = new int[h+1][w+1];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                presum[i+1][j+1] = grid[i][j] + presum[i][j+1] + presum[i+1][j] - presum[i][j];

                if(presum[i+1][j+1] <= k) res++;
            }
        }
        return res;
    }
}