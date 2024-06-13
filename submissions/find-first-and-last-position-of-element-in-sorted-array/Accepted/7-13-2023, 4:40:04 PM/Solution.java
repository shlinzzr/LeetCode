// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        
        int[] res = new int[]{-1,-1};
        
        if(len==0)
            return res;
        
        int st=0;
        int ed=len-1;
        
        // find first 
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(nums[mid]<target){
                st=mid+1;
            }else{
                ed=mid;
            }
        }
        
        int left = st;
        
        if(nums[left]!=target)
            return res;
        
        
        st=0;
        ed=len-1;
        while(st<ed){
            
            int mid = st+(ed-st)+1/2;
            
            if(nums[mid]>target){
                ed=mid-1;
            }else{
                st=mid;
            }
        }
        
        res[0]=left;
        res[1]=st;
        
        return res;
            
    }
}