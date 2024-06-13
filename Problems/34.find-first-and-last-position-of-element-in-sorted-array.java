// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        
        int left=-1, right=-1;
        
        if(len==0) return new int[]{left, right};
        int st=0, ed=len-1;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            if(nums[mid]>=target){
                ed = mid;
            }else if(nums[mid]<target){
                st = mid+1;
            }
        }
        
        if(nums[st]==target) left = st;
        
        st=0; ed=len-1;
        while(st<ed){
            int mid = ed-(ed-st)/2;
            if(nums[mid]<=target){
                st = mid;
            }else if(nums[mid]>target){
                ed= mid-1;
            }
        }
        
        if(nums[st]==target) right = st;
        
        return new int[]{left, right};
            
    }
}