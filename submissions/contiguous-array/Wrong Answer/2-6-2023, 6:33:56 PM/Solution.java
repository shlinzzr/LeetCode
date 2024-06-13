// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {
        
        int len = nums.length;
        int prev=-1;
        int sum=0;
        int max = 0;
        for(int i=0; i<len; i++){
            
            if(nums[i]==0)
                nums[i]=-1;
            
            sum+=nums[i];
            if(sum==0){
                max = Math.max(max, i-prev);
                
            }else{
                // prev=i;
            }
            
        }
        
        return max;
        
    }
}