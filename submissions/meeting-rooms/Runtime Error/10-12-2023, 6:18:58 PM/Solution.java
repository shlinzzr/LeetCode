// https://leetcode.com/problems/meeting-rooms

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        int[] curr = intervals[0];
        for(int i=1; i<intervals.length; i++){

            if(curr[1]>intervals[i][0])
                return false;
            
        }

        return true;
    }
}