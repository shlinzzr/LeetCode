// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        
        if(len==0)
            return new int[]{-1, -1};
        
        int st =0, ed=len-1;
        while(st<ed){
            int mid = st+(ed-st)/2;
            if(nums[mid]>=target)
                ed=mid;
            else
                st=mid+1;
        }
        
        int[] res = new int[2];
        
        res[0] = (nums[st]!=target)? -1 : st;
        
        st=0;
        ed=len-1;
        while(st<ed){
            int mid = st+(ed-st)+1/2;
            if(nums[mid]<=target)
                st=mid;
            else
                ed=mid-1;
        }
        
        res[1] = (nums[st]==target) ? st : -1;
        
        
        return res;            
    }
}