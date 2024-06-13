// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

class Solution {
    public int findMin(int[] nums) {
        // find k
        
        int st =0, ed = nums.length-1;
        
        while(st<ed){
            
            int mid = st + (ed-st)/2;
            
            
            if(nums[st] <= nums[mid] && nums[mid]<=nums[ed]){
                return nums[st];
                
            }else if( nums[mid] > nums[st] && nums[mid]>nums[ed]){
                st = mid+1;
                
            }else if( nums[mid] < nums[st] && nums[mid]<nums[ed]){
                ed = mid;
            }
            
        }
        
        return nums[st];
        
    }
}