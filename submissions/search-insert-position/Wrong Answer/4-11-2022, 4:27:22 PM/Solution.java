// https://leetcode.com/problems/search-insert-position

class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        int mid =0;
        while(lo<hi){
             mid = lo + (hi-lo)/2;
            
            if(target==nums[mid])
                return mid;
            else if(target>nums[mid])
                lo = mid+1;
            else
                hi = mid -1;
            
        }
            return target<nums[mid] ? mid : mid+1;
    }
}