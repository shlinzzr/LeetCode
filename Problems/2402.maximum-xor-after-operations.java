// https://leetcode.com/problems/maximum-xor-after-operations

class Solution {
    public int maximumXOR(int[] nums) {
        int max = 0;
        for(int n: nums){
            max |= n;
        }
        
        return max;
        
        
        
        // nums[i] = nums[i]&(nums[i]^nums[j]);
    }
}