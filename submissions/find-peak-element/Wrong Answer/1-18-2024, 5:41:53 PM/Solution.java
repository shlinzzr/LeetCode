// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;

        // find init edge case
        if(len==1) return nums[0];
        if(nums[0]>nums[1]) return nums[0];
        if(nums[len-1]>nums[len-2]) return nums[len-1];
        
        int st = 1 , ed=len-2;
        
        // is all about the mid

        while(st<ed){
            int mid = st+(ed-st)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) 
                return mid;

            if(nums[mid-1]< nums[mid]){
                st = mid+1;
            }else if(nums[mid-1]>nums[mid]){
                ed = mid;
            }
            
            // if(nums[mid]>nums[st] && nums[mid]>nums[ed]){// st ^mid^ ed
            //     if(nums[st]<nums[ed]){
            //         st = mid;
            //     }else 
            //         ed = mid;
            // }else if(nums[st]<nums[mid] && nums[mid]<nums[ed]){ // st mid ed (go up)
            //     st = mid;
            // }else if(nums[st]>nums[mid] && nums[mid]>nums[ed]){ // st mid ed (go down)
            //     ed = mid;
            // }else{
            //     st++;
            //     ed--;
            // }
        }
        
        return st;
        
    }
}