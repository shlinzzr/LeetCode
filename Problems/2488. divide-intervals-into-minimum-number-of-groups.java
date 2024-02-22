// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups

class Solution {
    public int minGroups(int[][] intervals) {
        int len = intervals.length;
        
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->a[1]-b[1]
        );

        int max = 0;
        for(int i=0; i<len; i++){
            int[] cur = intervals[i];

            while(!pq.isEmpty() && pq.peek()[1]<cur[0]){
                pq.poll();
            }

            pq.offer(cur);

            max = Math.max(max, pq.size());


        }

        return max;
    }
}