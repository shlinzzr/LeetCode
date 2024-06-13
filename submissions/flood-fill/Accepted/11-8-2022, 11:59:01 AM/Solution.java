// https://leetcode.com/problems/flood-fill

class Solution {
    
    int pick;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int p = image[sr][sc];
        
        floodFill(image, sr, sc, color, p);
        
        return image;
        
        
    }
    
    private void floodFill(int[][] image, int sr, int sc, int color, int p){
        
        int h= image.length;
        int w = image[0].length;
        
        if(sr<0 || sc<0 || sr>=h || sc >=w || image[sr][sc]==color || image[sr][sc]!=p )
            return;
        
        
        image[sr][sc] = color;
        
        floodFill(image, sr+1, sc, color,p);
        floodFill(image, sr-1, sc, color,p);
        floodFill(image, sr, sc+1, color,p);
        floodFill(image, sr, sc-1, color,p);
    }
    
}