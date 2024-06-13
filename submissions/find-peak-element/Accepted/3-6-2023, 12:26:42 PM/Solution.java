// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        
        int len = nums.length;
        if(len==1)
            return 0;
        
        int idx=0;
        for(int i=1; i<nums.length-1; i++){
            
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                idx =i;
                break;
            }
        }
        
        if((idx==0 || idx==len-2) && nums[len-2]<nums[len-1])
            return len-1;
        
        
        return idx;
    }
}