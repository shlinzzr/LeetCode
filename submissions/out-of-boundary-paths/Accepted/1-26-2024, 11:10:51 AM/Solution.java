// https://leetcode.com/problems/out-of-boundary-paths

public class Solution {
    public int findPaths(int m, int n, int N, int sr, int sc) {
        if (N <= 0) return 0;
        
        final int MOD = 1000000007;
        int[][] mat = new int[m][n];
        mat[sr][sc] = 1;
        int result = 0;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : dirs) {
                        int r = i + d[0];
                        int c = j + d[1];
                        if (r < 0 || r >= m || c < 0 || c >= n) {
                            result = (result + mat[i][j]) % MOD;
                        }
                        else {
                            temp[r][c] = (temp[r][c] + mat[i][j]) % MOD;
                        }
                    }
                }
            }
            mat = temp;
        }
        
        return result;
    }
}