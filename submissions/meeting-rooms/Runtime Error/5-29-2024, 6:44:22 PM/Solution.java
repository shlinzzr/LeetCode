// https://leetcode.com/problems/meeting-rooms

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        int[] prev =intervals[0];
        for(int i=1; i<intervals.length; i++){

            int[] curr = intervals[i];
            if(curr[0]<prev[1]) return false;

            if(prev[1] <= curr[0]){
                prev = curr;
                continue;
            }
        }

        return true;
        
    }
}