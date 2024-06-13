// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int len = nums.length;
        int sum=0, st=0;
        
        int min = Integer.MAX_VALUE;
        for(int ed=0; ed<len; ed++){
            
            sum+= nums[ed];
            if(sum<target) continue;
            
            
            
            while(sum>=target){
                if(sum>=target)
                    min = Math.min(min, ed-st+1);
                sum -= nums[st++];
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
        
    }
}