// https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels

class Solution {
    public int minArea(char[][] image, int x, int y) {
        int h = image.length;
        int w = image[0].length;
        
        int up=h, down=0, left=w, right=0;

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(image[i][j]=='1'){
                    up = Math.min(up, i);
                    down = Math.max(down, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }

            }
       }
    //    System.out.println(down + " " + up + " " + left + " " + right);

        return (down-up+1) * (right-left+1);

        
        
    }
}