// https://leetcode.com/problems/maximum-average-subarray-ii

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        //this video is awesome
        
        double left = nums[0];
        double right = nums[0];
        for(int n : nums){
            left = Math.min(left, n);
            right = Math.max(right, n);
        }
        
        while(right-left>1e-5){
            double mid = (left+right)/2;
            if(isOk(nums, k, mid)){
                left = mid;
            }else{
                right = mid;
            }
        }
        
        return left;
    }
    
    private boolean isOk(int[] nums, int k, double mid){
        
        double currSum = 0;
        double prevSum = 0;
        double minSum = 0;
        
        for(int i=0; i<nums.length; i++){
            currSum += nums[i]-mid;
            if(i>=k-1){
                if(currSum-minSum>=0) return true;
                prevSum += nums[i-k+1]-mid;
                minSum = Math.min(minSum, prevSum);
            }
        }
        return false;
    }
}