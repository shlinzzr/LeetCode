// https://leetcode.com/problems/meeting-rooms-ii

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int max = 0;
        int cnt = 1;
        
        if(intervals.length==1)
            return 1;
        
        Arrays.sort(intervals, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);

        
        
        
        int[] curr = intervals[0];
        for(int i=1; i<intervals.length; i++){
            
            int[] next = intervals[i];
            
            if(next[0]<curr[0]){
                cnt++;
               
                
            }else if (next[0]<curr[1]){
                cnt=2;
                
            }else{
                cnt=1;
                 
            }
            
             max = Math.max(max, cnt);
                
            
            curr[0] = Math.min(curr[1], next[1]);
            curr[1] = Math.max(curr[1], next[1]);
            
        }
        return max;
        
    }
}