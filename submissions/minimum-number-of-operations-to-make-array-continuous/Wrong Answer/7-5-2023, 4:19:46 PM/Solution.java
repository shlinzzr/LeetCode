// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous

class Solution {
    public int minOperations(int[] nums) {
        
        Arrays.sort(nums);
      
        
        int len = nums.length;
        
        int res = Integer.MAX_VALUE;
        
        int ed=0;
        for(int st=0; st<len; st++){
            
            while(ed<len && nums[ed]-nums[st] <= len-1){
                res = Math.min(res, len-(ed-st+1));
                ed++;
            }
        }
        
        
        return res;
        
        
    }
}