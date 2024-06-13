// https://leetcode.com/problems/search-insert-position

class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int st = 0, ed = len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                
                ed = mid;
            }else{
                
                st = mid+1;
            }            

        }
        
        
        return st==len-1 && target>nums[len-1] ? st+1 :st;
        
    }
}