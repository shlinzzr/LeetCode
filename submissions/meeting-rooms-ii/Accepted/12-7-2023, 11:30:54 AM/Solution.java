// https://leetcode.com/problems/meeting-rooms-ii

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>( //st, ed
            (a,b)-> a[1]-b[1]
        );

        int max= 1;
        for(int i=0; i<len; i++){
            int[] m = intervals[i];

            while(!pq.isEmpty() && pq.peek()[1]<=m[0]){
                pq.poll();
            }

            pq.offer(m);

            max = Math.max(max, pq.size());

        }

        return max;
    

        
    }
}