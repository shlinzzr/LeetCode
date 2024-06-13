// https://leetcode.com/problems/minimum-operations-to-remove-adjacent-ones-in-matrix

class Solution {

    int m;
    int n;

    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int minimumOperations(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        

        // init to -1
        int[][] match = new int[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(match[i], -1);
        }

        int ans = 0, count = 0;
        int[][] next = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j]==1 && dfs(i, j, ++count, grid, match, next)){
                    ans++;
                }
            }
        }

        return ans/2; // divide by 2 because we want num of pairs.
    }

    private boolean dfs(int i, int j, int visited, int[][] grid, int[][] match, int[][] next){
       
        if (next[i][j] == visited)
            return false;

        next[i][j]=visited;

        for (int[] d : dirs){
            int r = i + d[0];
            int c = j + d[1];
            if (r < 0 || c < 0 || r == m || c == n || grid[r][c] == 0 || next[r][c] == visited){
                continue;
            }
            if (match[r][c]==-1 || dfs(match[r][c]/n, match[r][c]%n, visited, grid, match, next)){
                match[r][c]=i*n+j;
                return true;
            }
        }
        return false;
    }
}