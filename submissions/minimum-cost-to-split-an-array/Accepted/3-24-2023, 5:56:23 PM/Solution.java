// https://leetcode.com/problems/minimum-cost-to-split-an-array

class Solution {
    public int minCost(int[] a, int k) {
        int n = a.length;
        int[] dp = new int[n + 1]; // dp[0] means optimal importance value for empty subarray, dp[1] means optimal importance value for array ending at[0, 1) i.e.[0, 0], dp[i] means optimal importance for array ending at i-1: [0, i) / [0, i-1]
        for (int i = 1; i <= n; i++) { // calc result for dp[1] to dp[n]
            dp[i] = Integer.MAX_VALUE;
            HashMap<Integer, Integer> m = new HashMap<>(); // count map, a new one for each i
            int score = k; // importance score always start with k for each subarray
            for (int j = i - 1; j >= 0; j--) { // since we know the optimal value in dp[j] for j : [0, i-1], where to put j will we yield best score for dp[i]? (Note: j = 0 means two sub arrays: [0, 0) + [0, i) which means there's only one subarray which is the whole thing
                int cnt = m.getOrDefault(a[j], 0);
                m.put(a[j], ++cnt);
                if (cnt == 2) score += 2; // only when we need a numnber for the second time, we start to add importance score, and it's going to be count as 2
                else if (cnt > 2) score++; // for 3rd time and more, each time we count one more importance score
                dp[i] = Math.min(dp[i], dp[j] + score);
            }
        }

        return dp[n];
    }
}
