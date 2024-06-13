// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int len = nums.length;
        
        int left=0, right= len-1;
        
        int st=-1;
        while(left<right){
            int mid = left+(right-left)/2;
            
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]==target){
                right=mid;
            }
        }
        if(nums[left]==target)
            st = left;
        
        right=len-1;
        int ed = -1;
        while(left<right){
            
            int mid = left+(right-left+1)/2;
            if(nums[mid]<target){
                left = mid +1;
                
            }else if(nums[mid]>target){
                right =mid-1;
                
            }else{
                left = mid;
            }
        }
        
        if(nums[left]==target)
            ed = left;
        
        
        return new int[]{st, ed};
        
        
        
        
    }
}