// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1] );
        
        int len = intervals.length;
        
        int[] prev = intervals[0]; //init
        
        int del =0;
        
        for(int i=1; i<len ;i++){
            
            int[] curr = intervals[i];
            
            if(curr[0]>=prev[1]){
                prev = curr;
            }else{
                prev[1] = Math.min(prev[1], curr[1]);
                del++;
            }
            
            
        }
        
        return del;
        
        
        
    }
}