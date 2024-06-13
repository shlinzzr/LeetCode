// https://leetcode.com/problems/maximum-subarray

class Solution {
  public int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        
        for(int i=0; i<len; i++){
            
            if(sum<0){
                sum=0;
            }
            
            sum+=nums[i];
            
            max = Math.max(max, sum);
        }
        
        
        return max;
  }
}