// https://leetcode.com/problems/find-xor-beauty-of-array

class Solution {
     int xor = 0;
    public int xorBeauty(int[] nums) {
        
        for(int n: nums){
            xor ^=n;
        }
        
        return xor;
        
        
    }
    
}