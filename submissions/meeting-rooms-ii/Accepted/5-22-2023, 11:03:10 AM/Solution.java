// https://leetcode.com/problems/meeting-rooms-ii

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int max = 0;
        int len = intervals.length;
        
        Arrays.sort(intervals, (a,b)->a[0]!=b[0]? a[0]-b[0] : a[1]-b[1]);
        
        
        PriorityQueue<int[] > pq = new PriorityQueue<>(
         (a,b) -> a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0]
        );
        
        //[[0,30],
        
        //[5,10],[15,20]]
        
        for(int[] curr : intervals){
            
            while(!pq.isEmpty() && curr[0] >= pq.peek()[1]){
                pq.poll();
            }
            
            pq.offer(curr);
            
            max = Math.max(max, pq.size());
        }
            
        return max;        
            
            
        
    }
}