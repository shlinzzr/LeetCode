// https://leetcode.com/problems/partition-to-k-equal-sum-subsets

class Solution {
    int cnt =0 ;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;

        int sum = 0 ;
        for(int n : nums){
            sum+=n;
        }

        if(sum%k!=0) return false;
        int target = sum/4;
        dfs(nums, 0, target);

        return cnt>=4;
    }

    private void dfs(int[] nums, int state, int target){
        if(target<0) return;
        if(target==0){
            cnt++;
            return ;
        }

        for(int i=0; i<nums.length; i++){
            if( (state & (1<<i))==0){
                dfs(nums, state|(1<<i), target-nums[i]);
            }
        }
    }
}