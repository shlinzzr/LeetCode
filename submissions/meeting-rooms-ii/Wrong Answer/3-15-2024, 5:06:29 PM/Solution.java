// https://leetcode.com/problems/meeting-rooms-ii

class Solution {
    public int minMeetingRooms(int[][] intervals) {


        int len = intervals.length;

        Arrays.sort(intervals, (a,b)-> (a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(intervals[0]);
        int max = 1;

        for(int i=1;  i<len; i++){

            int[] cur = intervals[i];

            while(!pq.isEmpty() && pq.peek()[1]<cur[0]){
                pq.poll();
            }

            pq.offer(cur);
            max = Math.max(pq.size(), max);
        }

        return max;


        
    }
}