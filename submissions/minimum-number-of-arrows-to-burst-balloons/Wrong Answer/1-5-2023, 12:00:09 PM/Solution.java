// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

class Solution {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        

        Arrays.sort(points, (a,b)->a[0]==b[0]?a[1]-b[1] : a[0]-b[0]);
        
        int[] prev = new int[2];
        prev[0] = points[0][0];
        prev[1] = points[0][1];
        
        int cnt=1;
        for(int i=1; i<len ;i++){
            
            int[] p = points[i];
            
            // System.out.println(prev[1] + " " + p[0]);
            
            if(prev[1]>=p[0]){
                // System.out.println(i + " cont");
                continue;
            }else{
                cnt++;
                // prev[0] = Math.max(p[0], prev[0]);
                prev[1] = p[1];
            }
        }
        
        return cnt;
    }
}