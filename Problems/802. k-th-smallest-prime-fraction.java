// https://leetcode.com/problems/k-th-smallest-prime-fraction

class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a, b) ->  A[a[0]] * A[b[1]] - A[a[1]] * A[b[0]]
        );
        
        // a[0]/a[1] <-> b[0]/b[1] 比大小  ==>  a[0]*b[1] <-> a[1]*b[0]

        for (int i = 1; i < A.length; ++i)
            pq.add(new int[]{0, i});    // (0,1),  (0,2), (0,3).....

        while (--K > 0) {
            int[] frac = pq.poll();
            if (frac[0]++ < frac[1])
                pq.offer(frac);  // (1,2), (1,3), (2,3).....   分子為1 補上k個
        }

        int[] ans = pq.poll();
        return new int[]{A[ans[0]], A[ans[1]]};
    }
}