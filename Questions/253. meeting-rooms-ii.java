// https://leetcode.com/problems/meeting-rooms-ii

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        
        int max=0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> a[1]-b[1]
        );
        
        for(int i=0; i<len; i++){
            int[] cur = intervals[i];
            pq.offer(cur);
            
            if(pq.peek()[1]<=cur[0]){
                pq.poll();
            }
            
            max = Math.max(max, pq.size());
        }
        
        return max;
        
    }
}