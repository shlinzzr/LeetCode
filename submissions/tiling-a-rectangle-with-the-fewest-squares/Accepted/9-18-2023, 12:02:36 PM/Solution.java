// https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares

class Solution {
    private int result = 14 * 14;
    
    public int tilingRectangle(int n, int m) {
        int[][] visited = new int[n][m];
        if (n == m) return 1;
        dfs(n, m, 0, visited);
        return result;
    }
    
    private void dfs(int n, int m, int cur, int[][] visited) {
        if (cur >= result) return;
        boolean full = true;
        int row = 0, col = 0;
        for (int i = 0; i < n && full; i++) {
            for (int j = 0; j < m && full; j++) {
                if (visited[i][j] == 0) {
                    full = false;
                    row = i;
                    col = j;
                }
            }
        }
        if (full) {
            result = Math.min(result, cur);
            return;
        }
        for (int len = Math.min(n - row, m - col); len > 0; len--) {
            full = false;
            for (int i = row; i < row + len && !full; i++) for (int j = col; j < col + len && !full; j++) if (visited[i][j] == 1) full = true;
            if (full) continue;
            for (int i = row; i < row + len; i++) for (int j = col; j < col + len; j++) visited[i][j] = 1;
            dfs(n, m, cur + 1, visited);
            for (int i = row; i < row + len; i++) for (int j = col; j < col + len; j++) visited[i][j] = 0;
        }
    }
}