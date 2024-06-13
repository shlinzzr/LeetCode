// https://leetcode.com/problems/count-submatrices-with-all-ones

class Solution {
    public int numSubmat(int[][] mat) {
        
            
        int h = mat.length;
        int w = mat[0].length;

        int res = 0;
        for(int i=0; i<h; i++){
            int[] row = new int[w];
            Arrays.fill(row, 1);
            
            for (int j = i; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    row[k] &= mat[j][k];
                }
                res += countOneRow(row);
            }
        }

        return res;
    }

    private int countOneRow(int[] row) {

        int res = 0, length = 0;
        for (int i = 0; i < row.length; ++i) {
            length = (row[i] == 0 ? 0 : length + 1);
            res += length;
        }
        return res;
    }
}