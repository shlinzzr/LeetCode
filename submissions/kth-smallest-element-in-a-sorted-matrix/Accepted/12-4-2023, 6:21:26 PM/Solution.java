// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;


        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]-b[0]
        );

        for(int i=0; i<len; i++){
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        while(!pq.isEmpty() && k-1>0){
            int[] p = pq.poll();

            int val = p[0];
            int i = p[1];
            int j = p[2];

            if(j+1<len){
                pq.offer(new int[]{matrix[i][j+1], i, j+1});
            }

            k--;

        }

        return pq.poll()[0];

    }
}