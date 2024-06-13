// https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares

class Solution {
    int ans = Integer.MAX_VALUE;
    int h,w;
    public int tilingRectangle(int n, int m) {
        this.h = n;
        this.w = m;
        dfs(0, 0, new boolean[h][w], 0);
        return ans;
    }

    private void dfs(int r, int c, boolean[][] rect, int cnt) {
        if (cnt >= ans) return;
        if (r >= h) {
            ans = cnt; 
            return;
        }
        if (c >= w) {
            dfs(r+1, 0, rect, cnt); 
            return;
        }
        if (rect[r][c]) {
            dfs(r, c+1, rect, cnt);
            return;
        }
        for (int k = Math.min(h-r, w-c); k >= 1 && isAvailable(rect, r, c, k); k--) {
            coverOrUncover(rect, r, c, k, true);
            dfs(r, c+k, rect, cnt+1);
            coverOrUncover(rect, r, c, k, false);
        }
    }
    private boolean isAvailable(boolean[][] rect, int r, int c, int k) {
        for (int i = r; i < r+k; i++){
            for (int j = c; j < c+k; j++){
                if (rect[i][j]) return false;
            }
        }
        return true;
    }
    private void coverOrUncover(boolean[][] rect, int r, int c, int k, boolean cover) {
        for (int i = r; i < r+k; i++){
            for (int j = c; j < c+k; j++){
                rect[i][j] = cover;
            }
        }
    }
}