// https://leetcode.com/problems/search-in-rotated-sorted-array-ii

class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        
        int offset = findMin(nums);
        
        int st=0;
        int ed=len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            int cvt = (mid+offset)%len;
            
            if(nums[cvt]==target)
                return true;
            
            else if(nums[cvt]>target){
                ed = mid-1;
                
            }else {
                st = mid+1;
            }
        }
    
        return (nums[(st+offset)%len]==target) ? true: false;
        
        
            
    }
    
    
    
    private int findMin(int[] nums){
        
        int len = nums.length;
        
        int st =0;
        int ed=len-1;
        
        while(st<ed){
            
            int m = st + (ed-st)/2;
            
            if(nums[m]>nums[ed]){
                st = m+1;
            }else{
                ed=m;
            }
        }
        
        return st;
    }
    
}