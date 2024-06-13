// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int len = intervals.length;
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int[] arr = intervals[0];

        int res= 0 ;
        for(int i=1; i<len; i++){
            int[] curr = intervals[i];


            if( curr[0] < arr[1]){
                res++;
                arr[1]=Math.min(arr[1], curr[1]);
            }else{
                arr = curr;   
            }

        }

        return res;

        
    }
}