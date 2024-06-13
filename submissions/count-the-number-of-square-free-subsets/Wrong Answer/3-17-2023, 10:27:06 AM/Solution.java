// https://leetcode.com/problems/count-the-number-of-square-free-subsets

class Solution {
   long[][] memo = new long[1001][1 << 11];
   int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
   private static final int MOD = 1000000007;
   public int squareFreeSubsets(int[] nums) {
       for (long[] array : memo) {
           Arrays.fill(array, -1);
       }        
       return (int) (dfs(0, 1, nums) - 1);
   }
   private long dfs(int index, int productMask, int[] nums) {
       // termination condition
       if (index >= nums.length) {
           return 1;
       }
       if (memo[index][productMask] != -1) {
           return memo[index][productMask];
       }
       // normal condition
       int mask = getMask(nums[index]);
       long result = dfs(index + 1, productMask, nums);
       if ((productMask & mask) == 0) {
           result = (result + dfs(index + 1, productMask | mask, nums)) % MOD;
       }
       memo[index][productMask] = result;
       return result;
   }
   private int getMask(long num) {
       int mask = 0;
       for (int i = 0; i < 10; i++) {
           int duplicates = 0;
           while (num % primes[i] == 0) {
               duplicates += 1;
               num /= primes[i];
           }
           if (duplicates > 1) {
               return -1;
           }
           if (duplicates == 1) {
               mask |= (1 << (i + 1));
           }
       }
       return mask;
   }
}