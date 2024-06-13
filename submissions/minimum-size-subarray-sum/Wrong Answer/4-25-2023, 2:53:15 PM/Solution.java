// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        
        int sum = 0;
        int min = len;
        int st =0;
        for(int ed =0; ed <len ; ed++){
            
            sum+=nums[ed];
            
            while(sum>target){
                sum-=nums[st++];
            }
            
            if(sum==target)
                min = Math.min(min, ed-st+1);
        }
        
        return min;
            
            
            
    }
}