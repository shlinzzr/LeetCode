// https://leetcode.com/problems/kth-largest-element-in-an-array



class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums, Collections.reverseOrder());  // can't sort reversed order with primitive array, but object array is fine
        
        Arrays.sort(nums);
        
        
        return nums[nums.length-k];
    }
}