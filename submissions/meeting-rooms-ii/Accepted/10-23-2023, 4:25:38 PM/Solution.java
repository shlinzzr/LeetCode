// https://leetcode.com/problems/meeting-rooms-ii

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        PriorityQueue<int[]> pq= new PriorityQueue<>(
            (a,b) -> a[1]-b[1]
        );

        int res = 1;

        for(int[] in : intervals){

            while(!pq.isEmpty() && pq.peek()[1]<=in[0]){
                pq.poll();
            }
            pq.offer(in);
            res = Math.max(res, pq.size());


        }

        return res;
    }
}