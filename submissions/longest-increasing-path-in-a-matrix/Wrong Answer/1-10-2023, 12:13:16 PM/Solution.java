// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

class Solution {
    
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        
        
        int max = 0;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                boolean[][] seen = new boolean[h][w];
                seen[i][j]=true;    
                int len = dfs(matrix, new int[]{i, j}, seen, 1);
                
                max = Math.max(max, len);
            }
        }
        
        return max;
        
    }
    
    
    private int dfs(int[][] matrix, int[] p, boolean[][] seen, int len){
        int h = matrix.length;
        int w = matrix[0].length;
        
        int max=len;
        for(int[] d : dirs){
            int r = d[0]+p[0];
            int c = d[1]+p[1];
            
            if(r>=0 && r<h && c>=0 && c<w && seen[r][c]==false){
                
                if(matrix[r][c]>matrix[p[0]][p[1]]){
                    seen[r][c]=true;
                    int l = dfs(matrix, new int[]{r,c}, seen, len+1);
                    max=Math.max(max, l);    
                }
            }
        }
        
        return max;
        
        
    }
}