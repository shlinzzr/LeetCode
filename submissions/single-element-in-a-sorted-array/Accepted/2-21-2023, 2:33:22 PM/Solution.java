// https://leetcode.com/problems/single-element-in-a-sorted-array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for(int n : nums){
            xor ^= n;
        }
        
        return xor;
    }
}