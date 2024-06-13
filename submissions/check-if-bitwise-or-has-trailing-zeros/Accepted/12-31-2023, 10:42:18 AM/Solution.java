// https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros

class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int len = nums.length;
        
        int cnt = 0 ;
        
        for(int i=0; i<len; i++){
                
              
            
                if(nums[i]%2==0)
                    cnt++;
                
                if(cnt>=2) return true;
        }
        
        return false;
        
    }
}