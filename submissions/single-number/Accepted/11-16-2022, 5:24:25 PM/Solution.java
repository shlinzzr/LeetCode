// https://leetcode.com/problems/single-number

class Solution {
    public int singleNumber(int[] nums) {
       
        int ans = 0;
        for(int n : nums){
            ans ^= n;
        }
        return ans;
    }
}