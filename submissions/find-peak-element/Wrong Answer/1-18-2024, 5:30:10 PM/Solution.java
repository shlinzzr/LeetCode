// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        
        int st = 0 , ed=len-1;
        
        while(st<ed){
            int mid = ed-(ed-st)/2;
            
            if(nums[mid]>nums[st] && nums[mid]>nums[ed]){// st ^mid^ ed
                if(nums[st]<nums[ed]){
                    st = mid;
                }else 
                    ed = mid;
            }else if(nums[st]<nums[mid] && nums[mid]<nums[ed]){ // st mid ed (go up)
                st = mid;
            }else if(nums[st]>nums[mid] && nums[mid]>nums[ed]){ // st mid ed (go down)
                ed = mid;
            }else{
                st++;
                ed--;
            }
        }
        
        return st;
        
    }
}