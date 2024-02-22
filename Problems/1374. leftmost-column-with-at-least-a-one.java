// https://leetcode.com/problems/leftmost-column-with-at-least-a-one

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int h = binaryMatrix.dimensions().get(0);
        int w = binaryMatrix.dimensions().get(1);

        int st = 0, ed = w - 1, ans = -1;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (existOneInColumn(binaryMatrix, h, mid)) {
                ans = mid;          // record as current ans
                ed = mid - 1;    // try to find in the left side
            } else {
                st = mid + 1;     // try to find in the right side
            }
        }
        return ans;
    }
    boolean existOneInColumn(BinaryMatrix binaryMatrix, int h, int mid) {
        for (int r = 0; r < h; r++) 
            if (binaryMatrix.get(r, mid) == 1) 
                return true;
     
        return false;
    }
}