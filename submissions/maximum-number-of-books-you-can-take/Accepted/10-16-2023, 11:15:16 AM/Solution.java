// https://leetcode.com/problems/maximum-number-of-books-you-can-take

class Solution {
    public long maximumBooks(int[] books) {
			int len = books.length;
			long[] maxEndingAt = new long[len];
			long res = maxEndingAt[0] = books[0];
			var candidateIndexes = new ArrayDeque<Integer>();
			candidateIndexes.push(0);
			for (int i = 1; i < len; i++) {
				while (!candidateIndexes.isEmpty()) {
					int j = candidateIndexes.peek();
					if (books[j] <= books[i] - i + j) {
						break;
					}
					candidateIndexes.pop();
				}
				int j = candidateIndexes.isEmpty() ? -1 : candidateIndexes.peek();
				long maxEndingAti = (j >= 0 ? maxEndingAt[j] : 0) + 
					triangularNumber(books[i]) - triangularNumber(books[i] - i + j);
				res = Math.max(res, maxEndingAti);
				maxEndingAt[i] = maxEndingAti;
				candidateIndexes.push(i);
			}
			return res;
    }

		private long triangularNumber(int n) {
			if (n <= 0) return 0;
			return n * (n + 1L) / 2;
		}
}