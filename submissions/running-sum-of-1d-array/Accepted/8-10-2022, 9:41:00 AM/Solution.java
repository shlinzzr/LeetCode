// https://leetcode.com/problems/running-sum-of-1d-array

class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        
        int total=0;
        int i=0;
        for(int n: nums){
            total += n;
            res[i++] = total;
        }
        
        return res;
    }
}