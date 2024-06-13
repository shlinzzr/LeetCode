// https://leetcode.com/problems/flipping-an-image

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        int h = image.length;
        int w = image[0].length;
        
        int[][] arr = new int[h][w];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                arr[i][w-j-1] = image[i][j]^1;
            }
        }
        
        return arr;
        
    }
}