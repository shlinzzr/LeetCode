// https://leetcode.com/problems/jump-game-viii

class Solution {
    public long minCost(int[] nums, int[] costs) {

        int len = nums.length;
        int idx = 0;

        long[] memo = new long[len];
        Arrays.fill(memo, -1);

        return helper(0, nums, costs, memo);

        // i k j 
        // nums[i]         <= nums[j]
        // nums[i] < nums[k]
        // 2 3 1, 2 3 2

        // nums[i]         > nums[j]
        // nums[i] <= nums[k]
        // ___
        // 2 2 1
        
        // 2 3 1 
        
    }


    private long helper(int i, int[] nums, int[] costs, long[] memo){

        if(memo[i]!=-1){
            return memo[i];
        }
        long cost = Integer.MAX_VALUE;
        int len = nums.length;


        for(int j=i+2; j<len; j++){
            if(nums[i]<=nums[j]){

                boolean valid = true;
                for(int k = i+1; k<j;k++){
                    if(nums[k]<=nums[i]){
                        valid = false;
                        break;
                    }
                }
                if(valid)
                    cost = Math.min(cost, costs[j] + helper(j, nums, costs, memo));
                else 
                    break;
            }
        }


        for(int j=i+2; j<len; j++){
            if(nums[i]>nums[j]){
                boolean valid = true;
                for(int k=i+1; k<j; k++){
                    if(nums[i]>nums[k]){
                        valid=false;
                        break;
                    }
                }
                if(valid){
                    cost = Math.min(cost, costs[j]+ helper(j, nums, costs, memo));
                }else 
                    break;
            }
        }



        memo[i] = cost;
        return memo[i];

    }
}