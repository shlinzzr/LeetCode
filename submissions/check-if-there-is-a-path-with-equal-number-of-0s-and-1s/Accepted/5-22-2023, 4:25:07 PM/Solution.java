// https://leetcode.com/problems/check-if-there-is-a-path-with-equal-number-of-0s-and-1s

class Solution {
    public boolean isThereAPath(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        if ((h  + w) % 2 == 0) {
            return false;
        }
        int[][] min = new int[h][w];
        int[][] max = new int[h][w];
        
        min[0][0] = max[0][0] = grid[0][0];
        for(int i = 1; i < h; ++i){
            min[i][0] = min[i - 1][0] + grid[i][0];
            max[i][0] = max[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < w; ++j){
            min[0][j] = min[0][j - 1] + grid[0][j];
            max[0][j] = max[0][j - 1] + grid[0][j];
        }
        for(int r = 1; r < h; ++r){
            for(int c = 1; c < w; ++c){
                
                
                
                int minPrev = Math.min(min[r - 1][c], min[r][c - 1]);
                min[r][c] = minPrev + grid[r][c];               
                int maxPrev = Math.max(max[r - 1][c], max[r][c - 1]);
                max[r][c] = maxPrev + grid[r][c];
                
                System.out.println(min[r][c] + " " + max[r][c]);
            }
        }
        int target = (h + w - 1) / 2;
        return min[h - 1][w - 1] <= target && max[h - 1][w - 1] >= target;
    }
    
    
}