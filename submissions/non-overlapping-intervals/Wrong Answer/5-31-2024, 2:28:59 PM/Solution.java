// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b)-> a[0]!=b[0] ? a[1] -b[1] :  a[0]-b[0] );

        int len = intervals.length;
        int cnt = 0;
        int[] prev = intervals[0];

        for(int i=1; i<len; i++){
            int[] curr = intervals[i];
            if(prev[1] <= curr[0]){
                prev = curr;
            }else{
                cnt++;
            }
        }
        
        return cnt;
    
        
    }
}