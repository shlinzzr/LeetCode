// https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target

class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int siz = nums.size();

        int[][] dp = new int[siz+1][target+1]; //看過i個數字後 能夠最長的subseq 組成target
        for(int[] d : dp){
            Arrays.fill(d, -1);
        } 

        for(int i=0; i<siz; i++){
            dp[i][0]=0;
        }



        for(int i=1; i<=siz; i++){
            for(int j=1; j<=target; j++){

                dp[i][j]=dp[i-1][j];

                if(j-nums.get(i-1)>=0 && dp[i-1][j-nums.get(i-1)]!=-1){
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-1][j-nums.get(i-1)]);
                }
            }
        }

        return dp[siz][target]==0 ? -1 : dp[siz][target];

    }
}