// https://leetcode.com/problems/check-if-it-is-a-straight-line

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0=coordinates[0][1];
        int x1 = coordinates[1][0], y1=coordinates[1][1];
        
        int dx = x0-x1, dy = y0-y1;
        
        for(int[] c : coordinates){
            
            int x = c[0];
            int y = c[1];
            
            // if(dx/dy!=(x-x0)/(y-y0))
            
            if( dx*(y1-y) != dy*(x1-x) )
                return false;
            
        }
        
        return true;
    }
}