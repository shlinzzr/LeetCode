// https://leetcode.com/problems/campus-bikes-ii

class Solution {
        
    int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(workers, bikes, new boolean[bikes.length], 0, 0);
        return min;
    }
    public void dfs(int[][] workers,int[][] bikes, boolean[] visit,int curr,  int idx ) {
        if (idx >= workers.length) {
            min = Math.min(curr, min);
            return ;
        }
        if (curr > min) {
            return ;
        }
        for (int j = 0; j < bikes.length; j++) {
            if (visit[j]) {
                continue;
            }
            visit[j] = true;
            dfs(workers, bikes, visit, curr + dis(bikes[j], workers[idx]), idx+1);
            visit[j] = false;
        }
        
    }
    public int dis(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
        
        
    
    
}