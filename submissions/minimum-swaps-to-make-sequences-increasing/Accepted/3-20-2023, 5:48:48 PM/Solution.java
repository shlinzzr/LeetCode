// https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing

class Solution {
    public int minSwap(int[] A, int[] B) {
        
           int changed = 1, unchanged = 0;
            for (int i=1; i<A.length; i++)
            {
                int changed_prev = changed;
                int unchanged_prev = unchanged;

                unchanged = Integer.MAX_VALUE;
                changed = Integer.MAX_VALUE;
                if (A[i-1]<A[i] && B[i-1]<B[i])
                    unchanged = Math.min(unchanged, unchanged_prev);
                if (B[i-1]<A[i] && A[i-1]<B[i])
                    unchanged = Math.min(unchanged, changed_prev);

                if (A[i-1]<B[i] && B[i-1]<A[i])
                    changed = Math.min(changed, unchanged_prev+1);
                if (B[i-1]<B[i] && A[i-1]<A[i])
                    changed = Math.min(changed, changed_prev+1);            
            }
            return Math.min(changed, unchanged);
        
        
    }
}