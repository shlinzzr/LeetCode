// https://leetcode.com/problems/n-repeated-element-in-size-2n-array

class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}