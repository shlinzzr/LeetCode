// https://leetcode.com/problems/bitwise-or-of-all-subsequence-sums

class Solution {
    public long subsequenceSumOr(int[] nums) {
        int len = nums.length;


        long presum, res = 0L;
        int sum = 0;

        int or = 0;
        for(int n : nums){
            sum += n;
            or |= sum;
            or |= n;
        }

        return or | sum;
        
    }
}