// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        
        int st=0;
        int ed=len-1;
        
        while(st<ed){
            
            int m = st+(ed-st)/2;
            
            if(nums[m]>nums[ed]){
                st = m+1;
                
            }else{
                ed=m;
            }
        }
        
        int offset = st+1;
        
        st=0;
        ed=len-1;
        while(st<ed){
            
            int m = st+(ed-st)/2;
            int real = (m + len + offset) % len;
            
            if(nums[real]==target){
                return real;
            }else if(nums[real]>target){
                st = m+1;
            }else{
                ed = m-1;
            }
        }
        
        int real = (st + len +offset) % len;
        
        
        return nums[real]==target ? real : -1;
        
        
    }
}