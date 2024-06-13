// https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero

class Solution {
    public boolean checkArray(int[] nums, int k) {
        
        int len = nums.length;
        
        for(int ed=0; ed<len-k; ed++){
            
            if(nums[ed]<0)
                return false;
            
            while(nums[ed]>0){
                for(int i=ed; i<k+ed; i++){
                    nums[i]--;
                }
            }
        }
        
        
        for(int i=0; i<len; i++){
            if(nums[i]!=0)
                return false;
        }
        
        return true;
    }
}