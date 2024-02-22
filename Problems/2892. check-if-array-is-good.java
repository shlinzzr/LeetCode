// https://leetcode.com/problems/check-if-array-is-good

class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        
        int len = nums.length;
        
        for(int i=0;i<len;i++){
            
            if(i==len-1){
                if(nums[i]!=len-1)
                    return false;
            }else
            
            
            if(nums[i]!=i+1)
                return false;
        }
        
        return true;
    }
}