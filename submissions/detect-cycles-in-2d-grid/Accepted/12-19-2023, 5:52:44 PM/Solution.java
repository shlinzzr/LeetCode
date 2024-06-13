// https://leetcode.com/problems/detect-cycles-in-2d-grid

class Solution {
    int count = 0;
    public boolean dfs(char[][] grid, int i, int j, int[][] seen, int previ, int prevj, char ch){
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=ch)
            return false;
       
        if(seen[i][j]-seen[previ][prevj]>=3)
            return true;

        if(seen[i][j]!=0)
            return false;
        
        seen[i][j]=count++;
        
        return dfs(grid,i+1,j,seen,i,j,ch) || dfs(grid,i-1,j,seen,i,j,ch) || dfs(grid,i,j+1,seen,i,j,ch) || dfs(grid,i,j-1,seen,i,j,ch);
    }
    public boolean containsCycle(char[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;

        int[][] seen = new int[h][w];

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(seen[i][j]==0 && dfs(grid, i, j, seen, i, j, grid[i][j]))
                    return true;
            }
        }
        return false;
    }
}