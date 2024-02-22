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
            int idx = (mid+offset+len)%len;
            if(nums[idx]==target){
                return idx;
            }else if(nums[idx]>target){
                ed = mid-1;
            }else 
                st = mid+1;
        }
        int idx = (st+offset+len)%len;
        if(nums[idx]==target) return idx;
        
        return -1;
        
    }
}