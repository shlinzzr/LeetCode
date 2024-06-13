// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        
        int st=0, ed=len-1;
        
        // find offset first
        
        while(st<ed){
            
            System.out.println(st + " " +ed);
            int mid = st+(ed-st)/2;
            
            if(nums[mid]>nums[ed])
                st=mid+1;
            else 
                ed=mid;  
            
               
        }
        // System.out.println(st);
        int offset = st;
        
        st=0;
        ed=len-1;
        
        while(st<=ed){
            
            int mid = st+(ed-st)/2;
            int mod = (mid+offset)%len;
            
            if(nums[mod]==target){
                return mod;
            }else if(nums[mod]>target){
                ed = mid-1;
            }else{
                st= mid+1;
            }
        }
        
        return -1;
        
    }
}