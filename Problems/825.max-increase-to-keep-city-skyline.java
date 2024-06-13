// https://leetcode.com/problems/max-increase-to-keep-city-skyline

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        
        
        int[] row = new int[n];
        int[] col = new int[n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                row[i] = Math.max(grid[i][j], row[i]);
                col[j] = Math.max(grid[i][j], col[j]);
                
            }    
        }
        
        int cnt =0;
         for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cnt  += Math.min(row[i], col[j])- grid[i][j];
                
            }    
        }
        
        return cnt;
        
        
            
    }
}