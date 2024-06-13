// https://leetcode.com/problems/max-value-of-equation

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int len = points.length;


        int max = Integer.MIN_VALUE;
        Deque<int[]> dq = new ArrayDeque<>();

        // PriorityQueue<int[]> pq = new PriorityQueue<>(
        //     (a,b) -> Math.abs(a[0]-b[0]) + a[1] + b[]
        // );

         // val = xj + yj - xi + yi  where j>i
        //  =>  xj -xi < k, 
        for(int j=0; j<len; j++){
            int[] p = points[j];

            

            //poll over distance;
            while(!dq.isEmpty() && p[0]-dq.peek()[0]>k){
                dq.poll();
            }

            // cal max
            if(!dq.isEmpty()){
                max = Math.max(max, p[0] + p[1] - dq.peek()[0] + dq.peek()[1]);
            }

            int val = -p[0] + p[1];
            while(!dq.isEmpty() && val> - dq.peekLast()[0] + dq.peekLast()[1]){
                dq.pollLast();
            }

            dq.offer(p);

        }

        return max;
    }
}