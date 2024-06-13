// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves

class Solution {
    public int minDifference(int[] nums) {
        
        int n = nums.length;
        
        if(n<=4)
            return 0;

        Arrays.sort(nums);
        
        return Math.min(nums[n-1]-nums[3],  Math.min(nums[n-2]-nums[2],  Math.min(nums[n-3]-nums[1], nums[n-4]-nums[0])));        
        
        // 6  6  0  1  1  4  6
        // 0  1  2  3       n-1
        //.      2.       n-2
        //.   1.      n-3 
        
        // 0 1 1 4 6 6 6 
    }
}