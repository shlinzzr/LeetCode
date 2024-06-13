// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        
        // find the smallest one
        
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
        System.out.println(offset);
        st=0; ed=len-1;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            int tran = (mid+offset)%len;
            if(nums[tran]==target){
                return mid;
            }else if(nums[tran]>target){
                ed = mid-1;
            }else 
                st = mid+1;
        }
        
        return st+offset;
        
    }
}