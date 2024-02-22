// https://leetcode.com/problems/apply-operations-to-an-array

class Solution {
    public int[] applyOperations(int[] nums) {
        int idx =0;
        int len = nums.length;
        for(int i=0; i<len; i++){
            
            if(nums[i]==0)
                continue;
            
            if(i+1<len && nums[i]==nums[i+1]){
                nums[idx] = 2 * nums[i];
                i++;
            }else {
                nums[idx] = nums[i];
                
            }
            idx++;
        }
        
        while(idx<len)
            nums[idx++]=0;
        
        return nums;
        
    }
}