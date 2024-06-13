// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

class Solution {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        
        Arrays.sort(points, (a,b)-> Integer.compare(a[0], b[0])==0?Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int[] p = new int[2];
        p[0] = points[0][0];
        p[1] = points[0][1];
        
        int cnt=1;
        
        for(int i=1; i<len; i++){
            
            // long[] next = new long[]{Long.valueOf(points[i][0]), Long.valueOf(points[i][1])};
            int[] next = points[i];
        
            // System.out.println(next[0]<=p[1]);
            
            if(next[0]<=p[1]){
                p[1]=Math.min(p[1], next[1]);
                continue;
            }else{
                cnt++;
                p[1] = next[1];
            }
        
        }
        
        return cnt;
    }
}