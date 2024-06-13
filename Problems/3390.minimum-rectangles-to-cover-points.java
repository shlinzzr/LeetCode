// https://leetcode.com/problems/minimum-rectangles-to-cover-points

class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        
        int len = points.length;
        
        int res = 0, right = -1;
        
        Arrays.sort(points, (a,b)-> a[0]-b[0]);
        
        
        
        
        for(int i=0; i<len; i++){
            int x = points[i][0];

            if(x > right){
                right = x+w;
                res++;
            }
          

        }
        
        return res;
        
    }
}