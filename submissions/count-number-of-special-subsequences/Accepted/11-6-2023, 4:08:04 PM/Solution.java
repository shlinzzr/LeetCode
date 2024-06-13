// https://leetcode.com/problems/count-number-of-special-subsequences

class Solution {
    public int countSpecialSubsequences(int[] nums) {
        int len = nums.length;

        //https://www.youtube.com/watch?v=P5TJZ8OZ2V4
        int M = (int) 1e9+7;

        long dp0 = 1, dp1 = 0, dp2 = 0;
        for (int i=0; i<len; i++)
        {
            if (nums[i]==0)
                dp0 = (dp0 * 2) % M;
            else if (nums[i]==1)
                dp1 = (dp0-1 + dp1*2) % M;
            else
                dp2 = (dp1 + dp2*2) % M;
        }
        return (int)dp2;        
    }
}