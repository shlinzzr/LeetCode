// https://leetcode.com/problems/flood-fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int h= image.length;
        int w = image[0].length;
        
        if(sr<0 || sc<0 || sr>=h || sc >=w || image[sr][sc]==color || image[sr][sc]==0)
            return image;
        
        image[sr][sc] = color;
        
        floodFill(image, sr+1, sc, color);
        floodFill(image, sr-1, sc, color);
        floodFill(image, sr, sc+1, color);
        floodFill(image, sr, sc-1, color);
        
        return image;
        
        
    }
}