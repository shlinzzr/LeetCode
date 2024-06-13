// https://leetcode.com/problems/jump-game-v

class Solution {
    public int maxJumps(int[] arr, int d) {
        // int len = arr.length;

        // int[] dp = new int[len+1]; //  maximum number of indices you can visit. seeing the first n ladders, 
        // Brute-Force : recur + memo

        int[] memo = new int[arr.length];
        int maxJumps = 0;

        for (int i=0; i<arr.length; i++) {
            maxJumps = Math.max(maxJumps, helper(i, memo, arr, d));
        }
        return maxJumps;
    }

    private int helper(int i, int[] memo, int[] arr, int d) {
        if (memo[i] != 0)
            return memo[i];

        int maxJumpsCount = 0;
        for (int x = i+1; x <= (i+d) && x < arr.length; x++) {
            if (arr[x] >= arr[i])
                break;
            maxJumpsCount = Math.max(maxJumpsCount, helper(x, memo, arr, d));
        }
        for (int x = i-1; x >= (i-d) && x >= 0; x--) {
            if (arr[x] >= arr[i])
                break;
            maxJumpsCount = Math.max(maxJumpsCount, helper(x, memo, arr, d));
        }
        memo[i] = 1 + maxJumpsCount;
        return memo[i];
    }
}