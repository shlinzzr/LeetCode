// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {

        int len = nums.length;
        if(len==1) return true;

        //     0. 1 2 3 4 5
        //       [3,2,1,0,4]
        // dp  T  T
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        dp[1] = true;

        for(int i=1; i<=len; i++){
            if(dp[i]){
                int n = nums[i-1];
                
                for(int j=i; j<=Math.min(len, i+n); j++){
                    dp[j] = true;
                }
            }

            // System.out.println(i);
            // for(int a=0; a<dp.length; a++){
            //     System.out.print(dp[a] + ",");
            // }
            // System.out.println();
        }

        return dp[len];


        
    }
}