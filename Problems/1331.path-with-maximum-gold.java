// https://leetcode.com/problems/path-with-maximum-gold

class Solution {
    public int getMaximumGold(int[][] grid) {
        
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        
        int maxSum = -1;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                    visited = new boolean[grid.length][grid[0].length];
                    maxSum = Math.max(maxSum,DFS(i,j,visited,grid));
            }
        }
        return maxSum;
    }
    
    int DFS(int i,int j, boolean[][] visited, int grid[][]) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j])
            return 0;
        
        visited[i][j] = true;
        int temp = -1;
        temp = Math.max(temp,grid[i][j]+DFS(i+1,j,visited,grid));
        temp = Math.max(temp,grid[i][j]+DFS(i-1,j,visited,grid));
        temp = Math.max(temp,grid[i][j]+DFS(i,j+1,visited,grid));
        temp = Math.max(temp,grid[i][j]+DFS(i,j-1,visited,grid));
        visited[i][j] = false;
        return temp;
    }
}