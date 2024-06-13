// https://leetcode.com/problems/partition-to-k-equal-sum-subsets

class Solution {
    int cnt =0 ;
    List<Integer> list = new ArrayList<>();

    Boolean[][] dp;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;

        dp = new Boolean[1<<len][k+1];

        int sum = 0 ;
        for(int n : nums){
            sum+=n;
        }

        if(sum%k!=0) return false;
        int target = sum/k;
        return dfs(nums, 0, 0, target, k);

    }

    private boolean dfs(int[] nums, int state, int cur , int target, int k){
        if(cur>target) return false;

        if(dp[state][k]!=null) return dp[state][k];
        if(cur==target){
            k--;
            if(k==0)
                return true;
            cur=0;
            
        }

        for(int i=0; i<nums.length; i++){
            if( (state & (1<<i))==0){
                list.add(i);
                boolean rt = dfs(nums, state|(1<<i), cur+ nums[i], target, k);
                list.remove(list.size()-1);
                if(rt) return true;
            }
        }

        dp[state][k]=false;
        return false;
    }
}