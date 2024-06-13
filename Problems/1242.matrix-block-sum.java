// https://leetcode.com/problems/matrix-block-sum

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int h = mat.length;
        int w = mat[0].length;
        int[][] presum = new int[h+1][w+1];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                presum[i+1][j+1] = mat[i][j] + presum[i][j+1] + presum[i+1][j] - presum[i][j];
            }
        }

        int[][] res = new int[h][w];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                int rmax = Math.min(h, i+k+1);
                int rmin = Math.max(0, i-k);

                int cmax = Math.min(w, j+k+1);
                int cmin = Math.max(0, j-k);

                // System.out.println(i+ " "+ j + " " + rmax + " " + cmax + " " + rmin + " " + cmin);

                res[i][j] = presum[rmax][cmax] 
                          - presum[rmax][cmin]
                          - presum[rmin][cmax]
                          + presum[rmin][cmin];



            }

        }
        return res;
    }
}