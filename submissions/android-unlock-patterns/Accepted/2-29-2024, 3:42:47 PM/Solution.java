// https://leetcode.com/problems/android-unlock-patterns

public class Solution {
    
    public int numberOfPatterns(int m, int n) {
        // Skip array represents number to skip between two pairs
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean seen[] = new boolean[10];
        int res = 0;
        // DFS search each length from m to n
        for(int i = m; i <= n; ++i) {
            res += DFS(seen, skip, 1, i - 1) * 4;    // 1, 3, 7, 9 are symmetric
            res += DFS(seen, skip, 2, i - 1) * 4;    // 2, 4, 6, 8 are symmetric
            res += DFS(seen, skip, 5, i - 1);        // 5
        }
        return res;
    }


    // cur: the current position
    // remain: the steps remaining
    private int DFS(boolean seen[], int[][] skip, int cur, int remain) {
        if(remain < 0) return 0;
        if(remain == 0) return 1;
        seen[cur] = true;
        int res = 0;
        for(int i = 1; i <= 9; ++i) {
            // If is not visited and (two numbers are adjacent or skip number is already visited)
            if(!seen[i] && (skip[cur][i] == 0 || (seen[skip[cur][i]]))) {
                res += DFS(seen, skip, i, remain - 1);
            }
        }
        seen[cur] = false;
        return res;
    }
    
}