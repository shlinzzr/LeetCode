// https://leetcode.com/problems/meeting-rooms-ii

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        int len = intervals.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> (a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0])
        );

        Arrays.sort(intervals, (a,b)->a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        
        // cur [[13,15]]

        // pq [1,13]

        int max = 0;
        for(int i=0; i<len; i++){
            int[] cur = intervals[i];
            while(!pq.isEmpty() && pq.peek()[1]<=cur[0])
                pq.poll();

            pq.offer(cur);
            max = Math.max(max, pq.size());
        }

        return max;
        
    }
}