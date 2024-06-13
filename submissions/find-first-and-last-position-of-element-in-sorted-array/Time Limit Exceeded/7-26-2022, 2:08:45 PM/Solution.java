// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int st=0, ed = nums.length-1, mid=(st+ed)/2;
        
        while(st<ed){
            
            mid = (st+ed)/2;
            
            if(nums[mid]==target)
                break;
            else if(nums[mid] < target)
                st = mid;
            else{
                ed = mid+1;
            }
            
            
        }
        
        
        int first = mid, last = mid;
        while(nums[mid]==nums[first-1]){
            first--;
        }
        
        while(nums[mid]==nums[last+1]){
            last++;
        }
        
        return new int[]{first, last};
        
    }
}