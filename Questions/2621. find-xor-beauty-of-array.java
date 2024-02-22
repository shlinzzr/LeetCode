// https://leetcode.com/problems/find-xor-beauty-of-array

class Solution {
    public int xorBeauty(int[] nums) {
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        return xor;
    }
    
}