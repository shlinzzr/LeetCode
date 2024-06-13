// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {

        // ref 322. Coin Change
        // ref 518. Coin Change II
        // ref 416. Partition Equal Subset Sum
        // ref 377. Combination Sum IV, 

        int sum = 0;
        for(int n : nums){
            sum += n;
        }

        if(sum%2!=0) return false;
        int target = sum/2;

        int len = nums.length;
        boolean[][] dp = new boolean[target+1][len+1];
        Arrays.fill(dp[0], true);

        for(int i=1; i<=len; i++){
            int c = nums[i-1];

            for(int j=1; j<=target; j++){
                dp[j][i] = dp[j][i-1];

                if(j-c>=0 && dp[j-c][i-1]){
                    dp[j][i] = true;
                }
            }
        }

        return dp[target][len];
        
    }

/*  // backtrack 我們就不看了

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