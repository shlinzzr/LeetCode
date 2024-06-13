// https://leetcode.com/problems/jump-game-v

class Solution {
    public int maxJumps(int[] arr, int d) {
        // int len = arr.length;

        // int[] dp = new int[len+1]; //  maximum number of indices you can visit. seeing the first n ladders, 
        // Brute-Force : recur + memo

        int[] memo = new int[arr.length];
        int res = 0;

        for (int i=0; i<arr.length; i++) { //從0-n-1開始
            res = Math.max(res, helper(i, memo, arr, d));
        }
        return res;
    }

    private int helper(int i, int[] memo, int[] arr, int d) {
        if (memo[i] != 0)
            return memo[i];

        int cnt = 0;
        for (int x = i+1; x <= (i+d) && x < arr.length; x++) {
            if (arr[x] >= arr[i])
                break;
            cnt = Math.max(cnt, helper(x, memo, arr, d));
        }
        for (int x = i-1; x >= (i-d) && x >= 0; x--) {
            if (arr[x] >= arr[i])
                break;
            cnt = Math.max(cnt, helper(x, memo, arr, d));
        }
        memo[i] = 1 + cnt;
        return memo[i];
    }
}