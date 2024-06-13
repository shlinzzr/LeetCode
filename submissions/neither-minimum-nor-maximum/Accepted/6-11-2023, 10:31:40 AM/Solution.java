// https://leetcode.com/problems/neither-minimum-nor-maximum

class Solution {
    public int findNonMinOrMax(int[] nums) {
        Arrays.sort(nums);
        
        int len = nums.length;
        
        if(len<3)
            return -1;
        
        return nums[1];
    }
}