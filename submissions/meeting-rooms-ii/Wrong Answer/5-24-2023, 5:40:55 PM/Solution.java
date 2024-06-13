// https://leetcode.com/problems/meeting-rooms-ii

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1]-b[1]
        );
        
        int len = intervals.length;
        int res = 1;
        
        
        for(int i=0; i<len; i++){
            
            int[] curr = intervals[i];
            
            while(!pq.isEmpty() && pq.peek()[1]<curr[0]){
                pq.poll();
            }
            
            pq.offer(curr);
            
            res = Math.max(res, pq.size());
        }
        
        return res;
        
    }
}