// https://leetcode.com/problems/minimum-time-visiting-all-points

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int res = 0;
        
        int[]  prev = null;
        
        for(int[] p : points){
            
            if(prev==null){
                prev = p;
                continue;
            }
            
            res += Math.max(Math.abs(p[0]-prev[0]),  Math.abs(p[1]-prev[1]));
            
            prev = p;
        }
        
        return res;
        
    }
}