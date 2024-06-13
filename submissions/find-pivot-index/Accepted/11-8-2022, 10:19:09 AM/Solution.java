// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        
        int len = nums.length;
        
        
        int right =0;
        for(int i=1; i<len; i++){
            right+=nums[i];
        }
        
        int left = 0;
        for(int i=0; i<len; i++){
            
            // System.out.println(left + ", " + right);
            
            if(left==right)
                return i;
            
            left+=nums[i];
            if(i+1<len)
                right-= nums[i+1];
            
            
        }
        
        return -1;
        
        
        
        
    }
}