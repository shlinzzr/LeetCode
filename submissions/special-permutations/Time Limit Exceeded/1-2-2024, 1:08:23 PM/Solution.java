// https://leetcode.com/problems/special-permutations

class Solution {
    int MOD = (int)1e9+7;
    int[][] dp ;
    public int specialPerm(int[] nums) {
        int n = nums.length;
        dp = new int[n][1<<n];
        return dfs(0,nums,0)%MOD;
    }
    public int dfs(int prevIndex, int[] nums, int mask){
        if(((1<<nums.length)-mask)==1) return 1;
        if(dp[prevIndex][mask]!=0) return dp[prevIndex][mask];
        int count = 0;
        for(int j=0;j<nums.length;j++){
            if((mask & (1<<j)) != 0) continue;
            if(mask==0 || nums[prevIndex]%nums[j]==0 || nums[j]%nums[prevIndex]==0){
                count = count%MOD + dfs(j,nums,(mask|(1<<j)))%MOD;
            }
        }
        return dp[prevIndex][mask]=count%MOD;
    }
}
