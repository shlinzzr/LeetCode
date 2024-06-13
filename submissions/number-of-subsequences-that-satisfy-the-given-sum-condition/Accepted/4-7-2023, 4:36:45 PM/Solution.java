// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, mod = (int)1e9 + 7;
        int len = nums.length;
        int left = 0, right=len-1;
        
        // precompute the pow arr
        int[] pows = new int[len];
        pows[0] = 1;
        for (int i = 1 ; i < len ; ++i)
            pows[i] = pows[i-1]*2 % mod;
        
        
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res = (res + pows[right-left]) % mod;
                left++;
            }
        }
        return res;
    }
}