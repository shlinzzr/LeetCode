// https://leetcode.com/problems/search-in-rotated-sorted-array-ii

class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        
        int offset = findMin(nums);
        
        int st=0;
        int ed=len-1;
         
        while(nums[st]==nums[ed] && st<ed && nums[ed-1]==nums[ed])
            ed--;
        ed--;
        
        
        
        System.out.println(offset);
        
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
        
        while(nums[st]==nums[ed] && st<ed && nums[ed-1]==nums[ed])
            ed--;
        
        while(st<ed){
            
            int m = st + (ed-st)/2;
            
            if(nums[m]==nums[ed]){
                ed--;
                
            }else if(nums[m]>nums[ed]){
                st = m+1;
            }else{
                ed=m;
            }
        }
        
          
//         while(st<ed){
            
//             // # shifting to remove duplicate elements
//             while( st<ed && nums[st] == nums[st+1] && nums[st]>=nums[ed])
//                 st++;
//             while( st<ed && nums[ed] == nums[ed-1])
//                 ed--;
            
//             System.out.println(st + " " + ed);
            
//             int mid = st+(ed-st)/2;
            
//             if(nums[mid]>nums[ed]){
//                 st=mid+1;
//             }else{
//                 ed=mid;
//             }
//         }
        
        
        return st;
    }
    
}