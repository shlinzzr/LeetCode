// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        
        int st=0;
        int ed=len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(nums[mid]==target)
                return mid;
            
            
            if(nums[mid]>=nums[0] == target>=nums[0]){
                
                if(nums[mid]>target){
                    ed=mid-1;
                }else{
                    st=mid+1;
                }
            }else if(target>nums[0]){
                
                ed=mid-1;
            }else{
                st = mid+1;
            }
        }
        
        if(st==ed && nums[st]==target){
            return st;
        }

        return -1;        
        
        
    }
}