// https://leetcode.com/problems/minimum-score-by-changing-two-elements

class Solution {
    public int minimizeSum(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        return Math.min(Math.min(A[n - 3] - A[0], A[n - 2] - A[1]), A[n - 1] - A[2]);
        
    }
}