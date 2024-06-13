// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
        
        
        int len = nums.length;
        
        if(len==0)
            return new int[]{-1, -1};
        
        
        int st = 0;
        int ed = len-1;
        
        while(st<ed){
            
            int mid = st+ (ed-st)/2;
            
            if(nums[mid]>=target){
                ed = mid;
            }else{
                st = mid+1;
            }
        }
        
        int left = -1;
        if(nums[st]==target)
            left=st;
        
        st=0;
        ed=len-1;
            
        while(st<ed){
            int mid = st+ (ed-st)+1/2;
            
            if(nums[mid]<=target){
                st = mid;
            }else{
                ed = mid-1;
            }
        }
        
        int right = -1;
        if(nums[st]==target)
            right = st;
        
        return new int[]{left, right};
        
        
        
    }
}