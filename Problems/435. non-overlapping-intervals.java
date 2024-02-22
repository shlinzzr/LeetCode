// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        
        int len = intervals.length;
        
        int[] prev = intervals[0]; //[[1,2],[1,3],[2,3],[3,4],]
        
        int del=0;
        
        for(int i=1; i<len; i++){
            
            int[] curr = intervals[i];
            
            // System.out.println(prev[0] + "," + prev[1] + " " + curr[0]+","+curr[1]);
            
            
            if(prev[1]<=curr[0]){
                prev= curr;
            }
            
            else if(prev[1] > curr[0] ){
                
                
                prev[1] = Math.min(prev[1], curr[1]);
                del++;
                
            }
        }
        
        return del;
    }
}