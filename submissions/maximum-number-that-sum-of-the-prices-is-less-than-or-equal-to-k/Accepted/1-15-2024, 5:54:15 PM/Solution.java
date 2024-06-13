// https://leetcode.com/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k

class Solution {
    private long getCurrSum(long num, int x) {
        long count = 0;
        for (int b = x - 1; b < 60; b += x) {
			// This gives the count of full cycles of bits in the binary representation of numbers from 1 to num.
            long fullCycles = num / (1L << (b + 1)); 
			//  count of set bits at the current position, given by (1L << b).
            count += fullCycles * (1L << b); 
			 // Calculate the remaining bits after the full cycles 
            long remaining = num % (1L << (b + 1));
			 // This part ensures that only the relevant remaining bits are considered, and any excess bits are ignored.
            count += Math.max(0, remaining - (1L << b));
        }
        return count;
    }
	
    public long findMaximumNumber(long k, int x) {
        long st = 1, ed= (long) 1e15, result = 0;
        while (st <= ed) {
            long mid = st + (ed - st) / 2;
            if (getCurrSum(mid + 1, x) <= k) {
                result = mid;
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return result;
    }
}