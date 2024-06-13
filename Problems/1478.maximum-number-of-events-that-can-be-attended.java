// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended

class Solution {
    public int maxEvents(int[][] events) {

        int len = events.length;
        Arrays.sort(events, (a, b) -> a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // endTime
     
        int res = 0;
        int i=0;

        for (int d = 1; d <= 100000; ++d) {

            while (i < len && events[i][0] == d){
                pq.offer(events[i][1]); // endTime
                i++;
            }

            // pop out of date endTime
            while (!pq.isEmpty() && pq.peek() < d){
                pq.poll();
            }
            
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        return res;
    }
}