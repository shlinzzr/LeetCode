// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int min = len+1;
        int st=0;
        
        int sum = 0;
        for(int ed=0; ed<len; ed++){
            
            sum+= nums[ed];
            
            while(sum>=target){
                min = Math.min(min, ed-st+1);
                sum-=nums[st++];
            }
        }
    
        return min==len+1? 0  : min;
    }
}