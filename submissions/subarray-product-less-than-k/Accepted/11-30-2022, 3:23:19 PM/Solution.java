// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int curr = 1;
        int st =0;
        for (int ed = 0;  ed< nums.length; ed++) {
            curr *= nums[ed];
            while (st <= ed && curr >= k) {
                curr /= nums[st++];
            }
            cnt += ed - st + 1;
        }
        return cnt;        
    }
}