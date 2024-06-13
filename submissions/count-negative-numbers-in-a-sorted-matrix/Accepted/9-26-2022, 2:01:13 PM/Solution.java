// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix

class Solution {
    public int countNegatives(int[][] grid) {
        int cnt =0;
        
        for(int j=grid.length-1; j>=0; j--){
            int[] g = grid[j];
            
            for(int i=g.length-1; i>=0; i--){
                if(g[i]<0)
                    cnt++;
                else
                    break;
            }
            
        }
        
        return cnt;
    }
}