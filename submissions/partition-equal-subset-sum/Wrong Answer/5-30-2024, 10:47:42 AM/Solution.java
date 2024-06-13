// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {

        
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

                if(j-c>=0 && dp[j-c][i]){
                    dp[j][i] = true;
                }
            }
        }

        return dp[target][len];
        
    }





















    //     // ref 322. Coin Change
    //     // ref 518. Coin Change II
    //     // ref 416. Partition Equal Subset Sum
    //     // ref 377. Combination Sum IV, 

    //     int len = nums.length;
    //     int sum = 0 ;

    //     for(int n : nums){
    //         sum+=n;
    //     }

    //     if(sum%2==1) return false;

    //     sum = sum/2;

    //     boolean[][] dp = new boolean[len+1][sum+1]; //use some of first i number which add up to sum
    //     dp[0][0] = true;

    //     // dp : 1 index, 
    //     // I.  dp[i][s] = dp[i-1][s] // 不選nums[i], 前i-1個已經可以組成s
    //     // II. dp[i][s] = dp[i-1][s-nums[i]] //選nums[i], 狀態就可以由 dp[i-1][s-nums[i]] 轉移過來
    //     // => dp[i][s] = dp[i-1][s] || (s-nums[i]>=0 && dp[i-1][s-nums[i]])

    //     for(int i=1; i<=len; i++){
    //         for(int s=0; s<=sum; s++){
    //             dp[i][s] = dp[i-1][s] || (s-nums[i-1]>=0 && dp[i-1][s-nums[i-1]]);
    //         }
    //     }
    //     return dp[len][sum];

    // } 




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