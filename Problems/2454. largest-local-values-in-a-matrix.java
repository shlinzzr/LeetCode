// https://leetcode.com/problems/largest-local-values-in-a-matrix

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int len = grid.length;
        
        int[][] res = new int[len-2][len-2]; 
        
        int[][] dirs = new int[][]{{0,0}, {0,-1}, {0,1}, {1,0}, {-1,0}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
        
        for(int i=1; i<len-1; i++){
            for(int j=1; j<len-1; j++){
                
                int max=0;
                for(int[] d : dirs){
                    max = Math.max(grid[i+d[0]][j+d[1]], max);
                }
                
                
                res[i-1][j-1]=max;
                
            }
        }
        
        return res;
    }
}