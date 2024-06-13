// https://leetcode.com/problems/spiral-matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        boolean[][] bool = new boolean[h][w];
        
        List<Integer> res = new ArrayList<>();
        
        int cnt =0;
        helper(matrix, res, 0, 0, bool, cnt);
        
        return res;
    }
    
    
    private void helper(int[][] matrix, List<Integer> res, int r, int c, boolean[][] bool, int cnt){
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        if(r>=h || r<0 || c>=w || c<0 || bool[r][c]==true)
            return;
        
        res.add(matrix[r][c]);
        bool[r][c]=true;
        
        int[][] dir = new int[][] {{0,1}, {1,0}, {0,-1}, {-1, 0}};
        int d = cnt %4;
        
        while(cnt < r*c){
            helper(matrix, res, r+dir[d][0], c+dir[d][1], bool, cnt);
            cnt++;    
        }
        
        
        /*Input
[[1,2,3,4],
 [5,6,7,8],
[9,10,11,12],
[13,14,15,16]]


*/
        //[1,2,3,4,8,12,16,15,14,13,9,10,11,7,6,5]
        
    }
    
}