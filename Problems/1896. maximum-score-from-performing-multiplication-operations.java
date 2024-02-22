// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations

class Solution {
    int n, m;
    int[] nums, muls;
    Integer[][] memo;
    public int maximumScore(int[] nums, int[] muls) {
        n = nums.length;
        m = muls.length;
        this.nums= nums;
        this.muls = muls;
        this.memo = new Integer[m][m];
        return dp(0, 0, n-1);
    }
    private int dp(int i, int l, int r) {
        if (i == m) return 0; // Picked enough m elements
        if (memo[l][i] != null) return memo[l][i];
        
        int pickLeft  = nums[l] * muls[i] + dp(i+1, l+1, r);  // Pick the left side
        int pickRight = nums[r] * muls[i] + dp(i+1, l, r-1); // Pick the right side
        return memo[l][i] = Math.max(pickLeft, pickRight);
    }
}