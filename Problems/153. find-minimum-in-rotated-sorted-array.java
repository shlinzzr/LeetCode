// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        
        int st=0, ed=len-1;
        
        if(nums[st]<=nums[ed]) //no rotate
            return nums[st];
        
        
        while(st<ed){
            
            int mid = st+ (ed-st)/2;
            if(nums[mid]>nums[ed]){
                st = mid+1;
            }else{
                ed = mid;
            }
        }
        
        
        return nums[st];
    }
}