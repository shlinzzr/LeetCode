// https://leetcode.com/problems/bricks-falling-when-hit

class Solution {
    private static final int TOP = 2;
    private static final int BRICK = 1; 
    private static final int EMPTY = 0;
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];
        // Think backwards: remove all of the hits and then add them back;
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]]--;
        }
        
        // Flood all the grids connecting to top with 2;
        for (int j = 0; j < grid[0].length; j++) {
            dfs(0, j, grid);
        }
        
        // Add back the hited Bricks
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            grid[x][y]++;
            if (grid[x][y] == BRICK && isConnected(x, y, grid)) {
                res[i] = dfs(x, y, grid) - 1;
            }
        }
        
        return res;
    }
    
    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != BRICK) {
            return 0;
        }        
        grid[i][j] = 2;
        return dfs(i + 1, j, grid) 
             + dfs(i - 1, j, grid)
             + dfs(i, j + 1, grid)
             + dfs(i, j - 1, grid) + 1;
    }
    
    private boolean isConnected(int i, int j, int[][] grid) {
        if (i == 0) {
            return true;
        }       
        for (int[] d : DIRS) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == TOP) {
                return true;
            }
        }               
        return false;
    }
}