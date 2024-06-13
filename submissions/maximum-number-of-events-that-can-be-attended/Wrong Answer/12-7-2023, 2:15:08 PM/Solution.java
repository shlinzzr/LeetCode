// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended

class Solution {
    public int maxEvents(int[][] events) {
        int len = events.length;


        int res = len;
        Arrays.sort(events, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]
        );

        for(int i=0; i<len; i++){
            pq.offer(events[i]);
        }


        int cur = 0;
        for(int i=0; i<len; i++){

            int[] p = pq.poll();
            if(cur<=p[0] && cur<p[1]){
                cur= p[1];
            }else if(cur>p[0] && cur>p[1]){
                cur=p[1];
                res--;
            }

            // System.out.println(i + " " +cur);
        }

        return res;

    }
}