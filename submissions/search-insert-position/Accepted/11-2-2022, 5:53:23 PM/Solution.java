// https://leetcode.com/problems/search-insert-position

class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int st =0, ed=nums.length;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            if(nums[mid]<target){
                st = mid+1;
            }else{
                ed = mid;
            }
        }
        
        return st;
        
        
    }
}