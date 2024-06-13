// https://leetcode.com/problems/binary-search

class Solution {
    public int search(int[] nums, int target) {
        int st=0, ed = nums.length;
        
        // Arrays.sort(nums);
        
        while(st<ed){
            
            int mid = (st+ed)/2;
            
             if(nums[mid]==target){
                 return mid;
            
             }else if(nums[mid]>target){
                
                ed = mid;
                
            }else{
                st=mid+1;
            }
            
            
        }
            
            
        return -1;
    }
}