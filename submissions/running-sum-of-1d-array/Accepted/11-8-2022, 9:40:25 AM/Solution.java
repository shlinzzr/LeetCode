// https://leetcode.com/problems/running-sum-of-1d-array

class Solution {
    public int[] runningSum(int[] nums) {
        
        int len = nums.length;
        
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            int sum = 0;
            for(int j=0; j<=i; j++){
                sum+=nums[j];
            }
            res[i]=sum;
        }
        
        return res;
    }
}