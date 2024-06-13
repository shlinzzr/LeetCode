// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

class Solution {
    
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        
        int h = matrix.length;
        int w = matrix[0].length;
        
        int[][] cache = new int[h][w];
        
        int max = 0;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                int len = dfs(matrix, new int[]{i, j}, cache);
                
                max = Math.max(max, len);
            }
        }
        
        return max;
        
    }
    
    
    private int dfs(int[][] matrix, int[] p, int[][] cache){
        int h = matrix.length;
        int w = matrix[0].length;

         if(cache[p[0]][p[1]] != 0) 
            return cache[p[0]][p[1]];
        
        
        int max=1;
        for(int[] d : dirs){
            int r = d[0]+p[0];
            int c = d[1]+p[1];
            
            if(r>=0 && r<h && c>=0 && c<w){
                
                if(matrix[r][c]>matrix[p[0]][p[1]]){
                    int l = 1 + dfs(matrix, new int[]{r,c}, cache);
                    max=Math.max(max, l);    
                }
            }
        }
        
        cache[p[0]][p[1]]=max;
        
        
        return max;
        
        
    }
}