// https://leetcode.com/problems/maximum-number-of-books-you-can-take

class Solution {
    public long maximumBooks(int[] books) {
			int len = books.length;
			long[] dp = new long[len];
			long res = dp[0] = books[0];

			for (int i = 1; i < len; i++) {
				int prev = books[i];
				long max = prev;
				for (int j = i - 1; j >= 0; j--) {
					if (books[j] <= prev - 1) {
						max += dp[j];
						break;
					}
					int curr = prev - 1;
					if (curr < 1) break;
					max += curr;
					prev = curr;
				}
				dp[i] = max;
				res = Math.max(res, max);
			}
			return res;
    }
}
    