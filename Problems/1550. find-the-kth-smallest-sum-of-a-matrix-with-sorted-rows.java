// https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int col = Math.min(mat[0].length, k);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat) {
            // max priority queue for the i-th row
            PriorityQueue<Integer> tmp = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : pq) {
                for (int c = 0; c < col; c++) {
                    tmp.add(i + row[c]);
                    // keep pq size <= k
                    if (tmp.size() > k) {
                        tmp.poll();
                    }
                }
            }
            pq = tmp;
        }
        return pq.poll();
    }
}