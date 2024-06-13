// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        
        int st=0, ed=len-1;
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(nums[mid]>nums[ed]){
                st = mid+1;
            }else{
                ed = mid;
            }
        }
        
        int offset = st;
        
        st=0;
        ed=len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            int cvt = (mid+offset)%len;
            
            if(nums[cvt]==target)
                return cvt;
            else if (nums[cvt]>target){
                ed = mid-1;
            }else{
                st = mid+1;
            }
            
        }
        
        int cvt = (st+offset)%len;
        return nums[cvt]==target ? cvt : -1;
            
    }
}