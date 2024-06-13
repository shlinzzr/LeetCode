// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        
        int sum = 0;
        int min = len+1;
        int st =0;
        for(int ed =0; ed <len ; ed++){
            
            sum+=nums[ed];
            
            while(sum>=target&& st<ed){
                 min = Math.min(min, ed-st+1);
                sum-=nums[st++];
            }
            
               
        }
        
        return min==len+1? 0  : min;
            
            
            
    }
}