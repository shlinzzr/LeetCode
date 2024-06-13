// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int len = points.length;

        Arrays.sort(points, (a,b)->a[0]-b[0]); // sort by x


        int max =0; 
        for(int i=0; i<len-1; i++){

            max = Math.max(max, points[i+1][0]-points[i][0]);

        }

        return max;

    }
}