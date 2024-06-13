// https://leetcode.com/problems/find-the-maximum-number-of-marked-indices

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int left = 0, right = (nums.length+1) / 2, res = 0;
        while(right < nums.length) {
            if(nums[left] * 2 <= nums[right]) {
                left++;
                res += 2;
            }
            right++;
        }
        return res;
    }
}