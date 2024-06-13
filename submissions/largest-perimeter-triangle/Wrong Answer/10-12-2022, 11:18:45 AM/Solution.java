// https://leetcode.com/problems/largest-perimeter-triangle

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] + nums[1] <= nums[2])
            return 0;
        else return nums[0] + nums[1] + nums[2];
    }
}