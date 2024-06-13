// https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target

class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int siz = nums.size();

        int[][] dp = new int[siz+1][target+1]; //看過i個數字後 能夠sum up to target 的longest subseq.length
        for(int[] d : dp){
            Arrays.fill(d, -1);// init : all case is inValid
        } 

        for(int i=0; i<siz; i++){
            dp[i][0]=0;  // 不管看過幾個數字 組成target==0的 longest subseq.length==0
        }


        // O(NK)
        for(int i=1; i<=siz; i++){ //i : 看過幾個數字
            for(int j=1; j<=target; j++){ // j : to sumup to

                dp[i][j]=dp[i-1][j];
                // 第i個數: nums.get(i-1)
                if(j-nums.get(i-1)>=0 && dp[i-1][j-nums.get(i-1)]!=-1){ // 如果現在第i個數比我要sum的j小 而且以前有成功過
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-1][j-nums.get(i-1)]); // 長度就+1
                }
            }
        }

        return dp[siz][target]==0 ? -1 : dp[siz][target];

    }
}