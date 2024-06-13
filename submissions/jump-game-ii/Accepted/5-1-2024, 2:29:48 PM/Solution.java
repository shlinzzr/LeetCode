// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
      

        for(int i=0; i<len-1; i++){

            if(i+nums[i]>=len-1){
                dp[len-1] = Math.min(dp[len-1], dp[i]+1);
                break;
            }

            for(int j=i+1; j<=i+nums[i]; j++){
                dp[j] = Math.min(dp[j], dp[i]+1);
            }

        }

        return dp[len-1];

        
    }
}