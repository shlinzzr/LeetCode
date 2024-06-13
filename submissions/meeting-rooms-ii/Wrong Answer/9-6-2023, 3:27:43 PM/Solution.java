// https://leetcode.com/problems/meeting-rooms-ii

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        
        int res= 0;
        
        Arrays.sort(intervals, (a,b)-> a[1]!=b[1]? a[1]-b[1] : a[0]-b[0]);
        
        int[] curr= intervals[0];
        
        int cnt =1;
        
        for(int i=1; i<len; i++){
            
            int[] in = intervals[i];
            
            if(in[0] < curr[1]){
                cnt++;
                curr[1] = Math.max(curr[1], in[1]);
            }
            
        }
        
        return cnt;
        
        
    }
}