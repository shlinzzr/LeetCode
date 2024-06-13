// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        
        int[] res = new int[]{-1, -1};
        
        if(len==0)
            return res;
        
        int st =0, ed=len-1;
        while(st<ed){
            int mid = st+(ed-st)/2;
            if(nums[mid]>=target)
                ed=mid;
            else
                st=mid+1;
        }
        
       
        if(nums[st]==target)
            res[0] = st;
        
        st=0;
        ed=len-1;
        while(st<ed){
            int mid = st+(ed-st)+1/2;
            if(nums[mid]<=target)
                st=mid;
            else
                ed=mid-1;
        }
        
        if(nums[st]==target)
            res[1] = st;
        
        return res;            
    }
}