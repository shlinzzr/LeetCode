// https://leetcode.com/problems/meeting-rooms

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        // Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        
        int[] p = new int[2];
        for(int[] i : intervals){
            
            if(p==null){
                p[0]=i[0];
                p[1]=i[1];
            }
                
            else{
                
                if(i[0] > p[1])
                    return false;
            }
            
        }
        
        return true;
    }
}