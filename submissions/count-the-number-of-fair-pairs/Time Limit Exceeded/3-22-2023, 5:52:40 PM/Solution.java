// https://leetcode.com/problems/count-the-number-of-fair-pairs

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        
        int cnt = 0;
        for(int ed=1; ed<nums.length; ed++){
            for(int st = 0; st<ed; st++){
                
                if(nums[st]+nums[ed]>=lower && nums[st]+nums[ed]<=upper)
                    cnt++;
            }
            
        }
        
        return cnt;
    }
}