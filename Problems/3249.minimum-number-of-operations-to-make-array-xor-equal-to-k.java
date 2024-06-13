// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k

class Solution {
    public int minOperations(int[] A, int k) {
        for (int a : A)
            k ^= a;
        return Integer.bitCount(k);
    }
}