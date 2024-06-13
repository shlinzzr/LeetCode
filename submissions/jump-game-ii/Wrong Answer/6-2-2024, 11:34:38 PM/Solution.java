// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {

        int len = nums.length;
        int currEnd = nums[0];

        int far = currEnd;
        int cnt = 0 ;
        for(int i=0; i<len; i++){

            far = Math.max(far, i+nums[i]);
            if(i==currEnd){
                cnt++;
                currEnd=far;
            }
        }

        return cnt;
/*


















        int len = nums.length;
        int[][] dp = new int[len+1][len+1]; // min steps with using the first i selection to add up to idx s
        for(int i=0; i<=len; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 1;

        // I.  dp[i][s] = dp[i-1][s] // not using nums[i-1]
        // II. dp[i][s] = Math.min(dp[i][s], dp[i-1][s-nums[i-1]]) //using nums[i], and "that is min"

        for(int i=1; i<=len; i++){
            dp[i][0] = dp[i-1][0];
            for(int s=1; s<=len; s++){
                if(s-nums[i-1]>=0 && dp[i-1][s-nums[i-1]]!=Integer.MAX_VALUE){
                    dp[i][s] = Math.min(dp[i-1][s], dp[i-1][s-nums[i-1]]);
                }
            }
        }

        return dp[len][len];
        */
        
    }
}