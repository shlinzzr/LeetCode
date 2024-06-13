// https://leetcode.com/problems/meeting-rooms

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {

        if(intervals.length==0) return true;

        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);

        int[] prev = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];

            if(curr[0]<prev[1]) return false;

            curr = prev;
        }

        return true;
        
    }
}