// https://leetcode.com/problems/meeting-rooms-ii

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int max = 0;
        int cnt = 1;
        
        if(intervals.length==1)
            return 1;
        
        Arrays.sort(intervals, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1]-b[1]
        );
        
        pq.add(intervals[0]);
        
        for(int i=1; i<intervals.length; i++){
            
            int[] next = intervals[i];
            
            if(next[1]>pq.peek()[1]){
                pq.poll();
            }
            pq.add(next);
            
        }
        
        return pq.size();
        
    }
}