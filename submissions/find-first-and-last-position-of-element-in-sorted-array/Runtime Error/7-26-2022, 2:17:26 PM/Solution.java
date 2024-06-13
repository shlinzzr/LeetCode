// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length==0)
            return new int[]{-1, -1};
        
        
        int st=0, ed = nums.length-1, mid=(st+ed)/2;
        
        while(st<ed){
            
            mid = (st+ed)/2;
            
            if(nums[mid]==target)
                break;
            else if(nums[mid] < target)
                st = mid+1;
            else{
                ed = mid;
            }
        }
        
        if(nums[mid]!=target)
            return new int[]{-1, -1};
        
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