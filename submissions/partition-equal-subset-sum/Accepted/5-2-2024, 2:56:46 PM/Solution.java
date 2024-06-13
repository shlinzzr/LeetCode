// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {

        int len = nums.length;
        int sum = 0 ;

        for(int n : nums){
            sum+=n;
        }

        if(sum%2==1) return false;

        sum = sum/2;

        boolean[][] dp = new boolean[len+1][sum+1]; //use first i to sum up j
        dp[0][0] = true;

        for(int i=1; i<=len; i++){
            for(int j=0; j<=sum; j++){

                dp[i][j] = dp[i-1][j];
                if(j-nums[i-1]>=0 && dp[i-1][j-nums[i-1]]){//如果前i-1個數字有拼成j-nums[i-1] 而且j-nums[i-1]又大於等於0
                    dp[i][j] = true;
                }
            }
        }

        return dp[len][sum];





    } 

/*
    private boolean helper(int[] nums, boolean[]seen, int left, int right, int target){
        if(left==target && right==target) return true;

        if(left>target|| right>target) return false;


        int len = nums.length;
        for(int i=0; i<len; i++){
            if(seen[i]) continue;
            for(int j=0; j<len; j++){

                if(seen[j] || i==j) continue;

                seen[i] = true;
                seen[j] = true;
                helper(nums, seen, left+nums[i], right)

            }
            

        }
    }   */

}