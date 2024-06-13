// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        int pivot = -1;
       
        int left=0, right=0;
        
        for(int i=1; i<nums.length; i++){
            right+= nums[i];
        }
        
        for(int i=0; i<nums.length-1; i++){
            if(left==right)
                return i;
            
            left+=nums[i];
            right-=nums[i+1];
        }
        
        
        return -1;
        
        
        
        
            
            
    }
}