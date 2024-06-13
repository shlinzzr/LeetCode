// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // presum + sliding window
        // https://www.youtube.com/watch?v=Ucepzsd2A4w
        
        int len = nums.length;
        
        int sum =0;
        
        int min = Integer.MAX_VALUE;
        
        // (st, ed]
        int st=0;
        for(int ed=0; ed<len; ed++){
            
            sum+=nums[ed];
            
            while(ed>=st && sum>=target){
                min = Math.min(min, ed-st+1);
                sum-=nums[st];
                st++;
            }
        }
        
        return min==Integer.MAX_VALUE ? 0: min;
            
        
        
    }
}