// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        int cnt = 0;

         Arrays.sort(intervals, (a,b)-> a[1]-b[1]);

        int[] prev = intervals[0];
        for(int i=1; i<len; i++){
            int[] curr = intervals[i];

            if(curr[0] < prev[1]){
                cnt++;
                prev[0] = Math.min(curr[0], prev[0]);
                prev[1] = Math.max(curr[1], prev[1]);
            }else{ // prev[1]<= curr[0]
                prev = curr;
            }
        }
        return cnt;
    }
}