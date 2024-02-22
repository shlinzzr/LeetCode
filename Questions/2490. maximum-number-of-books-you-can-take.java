// https://leetcode.com/problems/maximum-number-of-books-you-can-take

class Solution {
    public long maximumBooks(int[] books) {
			int len = books.length;
			long[] dp = new long[len];
			long res = dp[0] = books[0];
			Deque<Integer> dq = new ArrayDeque<>();
			dq.push(0);

			for (int i = 1; i < len; i++) {
				while (!dq.isEmpty()) {
					int j = dq.peek();
					if (books[j] <= books[i] - i + j) {
						 break;
					}
					dq.pop();
				}
				int j = dq.isEmpty() ? -1 : dq.peek();
				long max = (j >= 0 ? dp[j] : 0) + 
					triangularNumber(books[i]) - triangularNumber(books[i] - i + j);
				res = Math.max(res, max);
				dp[i] = max;
				dq.push(i);
			}
			return res;
    }

		private long triangularNumber(int n) {
			if (n <= 0) return 0;
			return n * (n + 1L) / 2;
		}
}