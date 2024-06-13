// https://leetcode.com/problems/single-number

class Solution {
    public int singleNumber(int[] nums) {
        int i=0;
        for(int n : nums){
            i ^= n;
        }
        
        return i;
    }
}