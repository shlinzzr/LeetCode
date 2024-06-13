// https://leetcode.com/problems/maximum-xor-for-each-query

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        
        int len = nums.length;
        int XOR = 0;
	    int[] ans = new int[len];
	    for(int  num : nums) 
            XOR ^= num;
        
        
	    ans[0] = XOR ^= (1 << maximumBit) - 1;  // 2^maximumBit - 1
	    for(int i = 1; i < len; i++)
		    ans[i] = XOR ^= nums[len - i];    
        
        
	    return ans;
            
    }
    
}