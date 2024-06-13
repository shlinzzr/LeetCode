// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k

class Solution {
    public int minOperations(int[] nums, int k) {

        int len = nums.length;

        int xor = 0;

        for(int n : nums){
            xor = xor^n;   
        }

        
        xor ^= k;
        int x = Integer.bitCount(xor);
        return x;

    }
}