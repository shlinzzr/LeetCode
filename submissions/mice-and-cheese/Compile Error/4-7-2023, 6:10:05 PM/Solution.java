// https://leetcode.com/problems/mice-and-cheese

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
         int res = 0, n = A.length, diff[] = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = A[i] - B[i];
            res += B[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < k; i++)
            res += diff[n - 1 - i];
        return res;
    }
}