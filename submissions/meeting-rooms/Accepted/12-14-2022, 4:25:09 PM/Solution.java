// https://leetcode.com/problems/meeting-rooms

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        
        int[] p = new int[2];
        for(int i=0; i<intervals.length; i++){
            
            int[] val = intervals[i];
            
            if(i!=0){
                               
                if(val[0] < p[1])
                    return false;
            }
            
            p[0]=val[0];
            p[1]=val[1];
            
        }
        
        return true;
    }
}