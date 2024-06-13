// https://leetcode.com/problems/search-in-rotated-sorted-array-ii

class Solution {
    public boolean search(int[] nums, int target) {
     
        int len = nums.length;
        if(len==1 && nums[0]==target)
            return true;
        
        
        // find min 
        int st = 0, ed=len-1;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            if(nums[mid]>nums[ed]){
                st=mid+1;
            }else{
                ed=mid;
            }
        }
        
        int fidx = st;
        // System.out.println()
        
        st=0;
        ed=len-1;
        while(st<ed){
            
            int left = (st+fidx)%len;
            int right = (ed+fidx)%len;
            
            int mid = st+(ed-st)/2;
            int tran = (mid+fidx)%len;
            
            if(nums[tran]==target)
                return true;
            else if(nums[tran]<target){
                st = mid+1;
            }else{
                ed=mid-1;
            }
        }
        
        return false;
        
        
        
        
    }
}