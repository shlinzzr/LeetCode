// https://leetcode.com/problems/kth-missing-positive-number

class Solution {
    public int findKthPositive(int[] A, int k) {
        
        int l = 0, r = A.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] - 1 - m < k)
                l = m + 1;
            else
                r = m;
            
            System.out.println("left="+l + " right="+r + " mid=" + m+ " A[m]="+A[m] + " (A[m]-1-m<k)="+(A[m] - 1 - m < k));
        }
        return l + k;
        
    }
}