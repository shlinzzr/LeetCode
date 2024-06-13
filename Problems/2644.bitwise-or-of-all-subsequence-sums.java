// https://leetcode.com/problems/bitwise-or-of-all-subsequence-sums

class Solution {
    public long subsequenceSumOr(int[] nums) {
        int len = nums.length;


        long  res = 0L;
        long sum = 0;

        long or = 0;
        for(int n : nums){
            sum += n;
            or |= sum;
            or |= n;
        }

        return or | sum;
        
    }
}