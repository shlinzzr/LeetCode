// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference

class Solution {

    int min = Integer.MAX_VALUE;
    long total = 0;
    public int minimumDifference(int[] nums) {
        int len = nums.length;

        int n = len/2;

        
        for(int i=0; i<len; i++){
            total+= nums[i];
        }

        // Long[][] dp = new Long[31][(1<<30)];

        dfs(nums, 0, 0, 0);

        return min;
    }

    private void dfs(int[] nums, int idx, int state, long cur/*, Long[][] dp*/){

        if(idx==nums.length){
            long a = total-cur;
            min = (int) Math.min(min, Math.abs(a-cur));
            return ;
        }

        // if(dp[idx][state]!=null) return;

        for(int i=0; i<nums.length; i++){
            if((state & (1<<i))==0){
                int nextState = (state | (1<<i));
                dfs(nums, idx+1, nextState, cur+nums[i]);
            }
        }

        // dp[idx][state] = min;
        // return;

    }

    

}