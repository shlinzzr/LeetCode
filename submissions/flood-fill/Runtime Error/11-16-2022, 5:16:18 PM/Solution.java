// https://leetcode.com/problems/flood-fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int h = image.length;
        int w = image[0].length;
        int orgColor = image[sr][sc];
        dfs(image, sr,sc, color, orgColor);
        
        return image;
    }
    
    int[][] dirs = new int[][]{{0,1}, {0,-1},{1,0}, {-1,0}};
    
    private void dfs(int[][]image, int sr, int sc, int color, int orgColor){
        
        int h = image.length;
        int w = image[0].length;
        
        
        for(int[] d : dirs){
            int r = sr+d[0];
            int c = sc+d[1];
            
            if(r>=0 && c>=0 && r<h && c<w && image[r][c]==orgColor){
                image[r][c] = color;
                dfs(image, r, c, color, orgColor);
            }
        }
        
        return;
        
        
    }
    
}