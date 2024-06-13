// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max = 0;
        
        
        for(int i=0; i<len; i++){
            sum+=nums[i];
            if(sum<0){
                sum=0;
            }
            
            max = Math.max(max, sum);
        }
        
        
        return max;
    }
}