// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

class Solution {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        
        Arrays.sort(points, (a,b)-> a[0]==b[0]?a[1]-b[1] : a[0]-b[0]);
        int[] p = points[0];
        
        int cnt=1;
        
        for(int i=1; i<len; i++){
            
            int[] next = points[i];
            
            if(next[0]<=p[1]){
                p[1]=Math.min(p[1], next[1]);
            }else{
                cnt++;
                p[1] = next[1];
            }
        
        }
        
        return cnt;
    }
}