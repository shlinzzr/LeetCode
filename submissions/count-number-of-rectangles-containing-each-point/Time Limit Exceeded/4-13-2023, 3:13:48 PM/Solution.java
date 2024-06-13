// https://leetcode.com/problems/count-number-of-rectangles-containing-each-point

class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] cnts = new int[points.length];
        
        for(int i=0; i<points.length; i++){
            
            int x = points[i][0];
            int y = points[i][1];
            
            for(int[] rect : rectangles){
                
                int c = rect[0];
                int r = rect[1];
                
                if( (0<=x && x<=c) && (0<=y&& y<=r)){
                    cnts[i]++;
                }
            }
        }
        
        return cnts;
        
    }
}