// https://leetcode.com/problems/flood-fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int h = image.length;
        int w = image[0].length;
        
        int src = image[sr][sc];
        
        dfs(image, sr, sc, color, h, w, src);
        
        return image;
        
    }
    
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
    
    
    private void dfs(int[][] image, int i, int j, int color, int h, int w, int src){
        
        
        image[i][j] = color;
        
        for(int[] d : dirs){
            int r = i+d[0];
            int c = j+d[1];
            if(r<0 || r>=h || c<0 || c>=w){
                continue;
            }
            
            
            if(image[r][c]==src && image[r][c]!=color)
                dfs(image, r, c, color, h, w , src);
        }
    }
}