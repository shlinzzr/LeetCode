// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        int cnt = 1 ;
        
        int len = nums.length;
        
        int res =1;
        
        for(int i=0; i<len-1 ;i++){
            if(nums[i]<nums[i+1]){
                cnt++;
                res = Math.max(cnt, res);
            }else 
                cnt=1;
        }
        cnt=1;
         for(int i=len-2; i>=0 ;i--){
            if(nums[i]>nums[i+1]){
                cnt++;
                res = Math.max(cnt, res);
            }else 
                cnt=1;
        }
        
        return res;
        
    }
}