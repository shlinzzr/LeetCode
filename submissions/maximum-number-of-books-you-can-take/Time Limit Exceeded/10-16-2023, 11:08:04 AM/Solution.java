// https://leetcode.com/problems/maximum-number-of-books-you-can-take

class Solution {
    public long maximumBooks(int[] books) {
            int len = books.length;
			long res = 0;
			for (int i = 0; i < len; i++) {
				int prev = books[i];
				long max = prev;
				for (int j = i - 1; j >= 0; j--) {
					int curr = Math.min(books[j], prev - 1);
					if (curr < 1) break;
					max += curr;
					prev = curr;
				}
				res = Math.max(res, max);
			}
			return res;
    }
}