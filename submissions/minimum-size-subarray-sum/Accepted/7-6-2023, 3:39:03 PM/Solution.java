// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        
        int sum = 0;
        
//         int ed =0;
//         for(int st=0; st<len; st++){
            
//             while(ed<len && sum<target){
//                 sum+=nums[ed++];
//             }
            
//             min = Math.min(ed-st+1, min);
            
//             sum-=nums[st];
            
//         }
        
        int st=0; 
        for(int ed=0; ed<len; ed++){
            
            sum+=nums[ed];
            
            while(sum-nums[st]>=target){
                sum -= nums[st];
                st++;
            }
            
            if(sum>=target)
             min = Math.min(min, ed-st+1);
        }
        
        
        
        return min==Integer.MAX_VALUE ? 0 : min;
        
    }
}