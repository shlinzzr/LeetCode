// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups

class Solution {
    public int minGroups(int[][] intervals) {
        int len = intervals.length;

        int max = 1;

        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1]-b[1]
        );

        for(int i=0; i<len; i++){

            pq.offer(intervals[i]);
            while(!pq.isEmpty() && pq.peek()[1]<intervals[i][0]){
                pq.poll();
            }

            max = Math.max(max, pq.size());

        }


        return max;
        
    }
}