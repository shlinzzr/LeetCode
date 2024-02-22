// https://leetcode.com/problems/special-permutations

class Solution {

    int M = (int) 1e9+7;
    Integer[][] dp ;

    public int specialPerm(int[] nums) {
        int len = nums.length;
        dp = new Integer[1<<len][len];
        for(int i=0; i<len ; i++) dp[i] = new Integer[len];

        long rt = dfs(nums, 0, -1, 0, dp);

        return (int) (rt%M);
    }

    private long dfs(int[] nums, int idx, int prev, int state, Integer[][]dp){

        // System.out.println("dfs cnt="+cnt +  " state="+state + " list="+list);
        if(idx>=nums.length) return 1;
        if(prev!=-1 && dp[state][prev]!=null) {
            //  System.out.println("dp[state]="+ dp[state]);
             return dp[state][prev];
        }
        long res = 0;
        for(int j=0; j<nums.length; j++){
            if((state & (1<<j))==0 && (state==0 || nums[prev]%nums[j]==0 || nums[j]%nums[prev]==0)){
                int newState = state | (1<<j);
                // System.out.println("cnt="+cnt + " j="+j + " state=" + state + " newState="+newState);
                res = (res + dfs(nums, idx+1, j, newState, dp)%M)%M;
                
            }
        }

        if(prev!=-1)dp[state][prev] = (int)(res%M);
        return res%M;
    }

}