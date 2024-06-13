// https://leetcode.com/problems/left-and-right-sum-differences

class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int len = nums.length;
        
        int[] leftSum = new int[len];
        int[] rightSum = new int[len];
        
        int sum = 0;
        for(int i=0; i<len;i++){
            leftSum[i]=sum;
            sum+=nums[i];
        }
        
        int[] res = new int[len];
        
        sum = 0;
        for(int i=len-1; i>=0;i--){
            
            res[i] = Math.abs(leftSum[i]-sum);
            sum+=nums[i];
        }
        
        return res;
        
    }
}