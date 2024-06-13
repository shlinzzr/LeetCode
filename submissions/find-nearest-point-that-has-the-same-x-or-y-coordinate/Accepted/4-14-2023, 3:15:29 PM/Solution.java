// https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int dis = Integer.MAX_VALUE;
        int res = -1;
        
        
        for(int i=0; i<points.length; i++){
            
            int[] p = points[i];
            
            if(p[0]==x || p[1]==y){
                
                int d = Math.abs(x-p[0]) + Math.abs(y-p[1]) ;
                if(d< dis){
                    res = i ;
                    dis = d;
                }
            }
        }
        
        return res;
        
    }
}