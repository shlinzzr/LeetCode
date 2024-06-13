// https://leetcode.com/problems/rotate-array

class Solution {
    public void rotate(int[] nums, int k) {
        
        reverse(nums, 0, k);
        reverse(nums, k+1, nums.length-1);
        reverse(nums, 0, nums.length-1);
        
    }
    
    private void reverse(int[] nums, int st, int ed){
        
        while(st<ed){
            int tmp = nums[st];
            nums[st]=nums[ed];
            nums[ed] = tmp;
            
            st++;
            ed--;
        }
        
    }
}