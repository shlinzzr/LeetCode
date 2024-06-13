// https://leetcode.com/problems/find-peak-element

class Solution {
    
    // 1. find the initilize edge case
    // 2. follow your instinct
    
    
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        
		if(len == 1) return 0; // single element
        
		// check if 0th/n-1th index is the peak element
        if(nums[0] > nums[1]) return 0;
        if(nums[len-1] > nums[len-2]) return len-1;
		
		// search in the remaining array
        int st = 1;
        int ed = len-2;
        
        while(st<ed) {
            int mid = st+ (ed-st)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) 
                return mid;
            
            else if(nums[mid-1] > nums[mid]) 
                ed = mid - 1;
            
            else if(nums[mid+1] > nums[mid]) 
                st = mid + 1;
        }
        
        
        return (nums[st] > nums[st-1] && nums[st] > nums[st+1]) ? st : -1;
    }
}