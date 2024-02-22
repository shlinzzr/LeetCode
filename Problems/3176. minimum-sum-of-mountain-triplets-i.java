// https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i

class Solution {
    public int minimumSum(int[] nums) {
        int len = nums.length;
        
        
        int sum = Integer.MAX_VALUE;
        
            
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                for(int k=j+1;k<len; k++){
                    
                    if(nums[i] < nums[j] && nums[k] < nums[j])
                        sum = Math.min(sum, nums[i]+nums[j]+nums[k]);
                }
            }
        }
        
        return sum==Integer.MAX_VALUE? -1 : sum;
    }
}