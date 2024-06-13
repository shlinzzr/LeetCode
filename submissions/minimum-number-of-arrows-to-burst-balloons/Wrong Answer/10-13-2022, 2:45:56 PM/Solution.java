// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1,p2)->p1[0]-p2[0]);
        
        int[] prev = points[0];
        int cnt =0;
        
        for(int i=1; i<points.length; i++){
            int[] p = points[i];
            
            if(p[0]<prev[1]){
                cnt++;
                prev[1] = Math.min(prev[1], p[1]);
            }else{
                prev = p;
            }
        }
        
        return cnt;
    }
}