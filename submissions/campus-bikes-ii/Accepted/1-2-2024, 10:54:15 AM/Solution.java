// https://leetcode.com/problems/campus-bikes-ii

class Solution {
    
    int[] memo;
    int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        memo = new int[workers.length];
        dfs(new boolean[bikes.length], workers, 0, bikes, 0);
        return min;
    }
    public int dfs(boolean[] visit, int[][] workers, int i, int[][] bikes, int distance) {
        if (i >= workers.length) {
            min = Math.min(distance, min);
            return 0;
        }
        if (distance > min) {
            return 0;
        }

        if(memo[i]!=0) return memo[i];
        int rt = Integer.MAX_VALUE;

        for (int j = 0; j < bikes.length; j++) {
            if (visit[j]) {
                continue;
            }
            visit[j] = true;
            rt = Math.min(rt, dfs(visit, workers, i + 1, bikes, distance + dis(bikes[j], workers[i])));
            visit[j] = false;
        }

        memo[i] = rt;
        return rt;
    }
    public int dis(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
        
        
    
    
}