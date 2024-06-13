// https://leetcode.com/problems/campus-bikes-ii

    
// State reducing dynamic programming
class Solution {
    
    // happygirlzt backtraking -> bit state compress
    // https://www.youtube.com/watch?v=nyOE2x5vTUk
    
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = bikes.length;
        int[] memo = new int[1 << n]; // 2^n choices
        return dfs(workers, bikes, 0, 0, memo);
    }

    private int dfs(int[][] workers, int[][] bikes, int widx, int state, int[] memo) {
        if (widx == workers.length) 
            return 0;
        
        if (memo[state] != 0)  return memo[state];
        
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < bikes.length; i++) {
            if ((state & (1 << i)) == 0) { // bike is not overlap used
                
                int nextBikesState = state | (1<<i);
                
                min = Math.min(min, getDistance(workers[widx], bikes[i]) + dfs(workers, bikes, widx + 1, nextBikesState, memo));
            }
        }

        memo[state] = min;
        return min;
    }
    
    private int getDistance(int[] a, int[] b){
        
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
            
    }
    
}