// https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst

class Solution {
    private static final int M = (int)1e9+7;
    public int numOfWays(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return countWays(list) - 1;
    }
    private int countWays(List<Integer> nums) {
        if (nums.size() <= 2) { //兩個node, 第一個為root, 組bst只有一種組合方法
            return 1;
        }
        
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = nums.get(0);
        
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }
        
        long leftCount = countWays(left);
        long rightCount = countWays(right);
        
        return (int) ((comb(nums.size() - 1, left.size()) % M) * (leftCount % M) % M * (rightCount % M) % M);
    }
    
    private long comb(int n, int k) { // C N取K
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % M;
            }
        }
        return dp[n][k];
    }
}