// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        
        // presum + sliding window
        
        int len = nums.length;
        
        int sum =0;
        
        int min = Integer.MAX_VALUE;
        
        // (st, ed]
        
        int st=-1;
        for(int ed=0; ed<len; ed++){
            
            sum+=nums[ed];
            
            while(ed>=st && sum>=target){
                min = Math.min(min, ed-st);
                st++;
                sum-=nums[st];
            }
        }
        
        return min==Integer.MAX_VALUE ? 0: min;
            
        
        
    }
}