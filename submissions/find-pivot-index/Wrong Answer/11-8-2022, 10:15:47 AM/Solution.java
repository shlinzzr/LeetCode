// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        
        int len = nums.length;
        
        
        int right =0;
        for(int i=2; i<len; i++){
            right+=nums[i];
        }
        
        int left = nums[0];
        for(int i=1; i<len-1; i++){
            
            if(left==right)
                return i;
            
            left+=nums[i];
            right-= nums[i+1];
        }
        
        return -1;
        
        
        
        
    }
}