// https://leetcode.com/problems/minimum-rectangles-to-cover-points

class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        
        int len = points.length;
        
        int ed = points[0][0];
        int st = ed;
        
        int res = 0 ;
        
        Arrays.sort(points, (a,b)-> a[0]-b[0]);
        
        
        
        
        for(int i=0; i<len; i++){
            
            int x = points[i][0];
            int y = points[i][1];
            
            int j=i;
            while(j+1<len && points[j+1][0]-x<=w){
                j++;
            }
            
            res++;
            i=j;
        }
        
        return res;
        
    }
}