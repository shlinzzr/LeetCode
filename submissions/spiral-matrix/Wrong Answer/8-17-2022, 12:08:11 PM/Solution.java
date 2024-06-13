// https://leetcode.com/problems/spiral-matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        boolean[][] bool = new boolean[h][w];
        
        List<Integer> res = new ArrayList<>();
        helper(matrix, res, 0, 0, bool);
        
        return res;
    }
    
    
    private void helper(int[][] matrix, List<Integer> res, int r, int c, boolean[][] bool){
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        if(r>=h || r<0 || c>=w || c<0 || bool[r][c]==true)
            return;
        
        res.add(matrix[r][c]);
        bool[r][c]=true;
        
        helper(matrix, res, r, c+1, bool);
        helper(matrix, res, r+1, c, bool);
        helper(matrix, res, r, c-1, bool);
        helper(matrix, res, r-1, c, bool);
        
        
    }
    
}