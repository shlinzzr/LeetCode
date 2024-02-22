// https://leetcode.com/problems/row-with-maximum-ones

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;
        
        int max = 0;
        
        int[] res = new int[]{0, 0};
        
        
        for(int i=0; i<h; i++){
            
            int sum = 0;
            for(int j=0; j<w; j++){
                sum += mat[i][j];
            }
            
            if(sum>max){
                max = sum;
                res = new int[]{i, sum};
            }
        }
        
        return res;
        
    }
}