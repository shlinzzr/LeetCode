// https://leetcode.com/problems/minimum-cost-to-make-array-equal

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int len =nums.length;
        int[] arr = new int[nums.length];
        
        int total = 0;
        int w = 0;
        for(int i=0; i<len; i++){
            arr[i] = nums[i] * cost[i];
            total+=arr[i];
            w+=cost[i];
        }
        
        double avg = total/w;
        long target = Math.round(avg);
        
        long res = 0;
        
        for(int i=0; i<len; i++){
            res += Math.abs(nums[i]-target)*cost[i];
        }
        
        return res;
        
        
        
        
    }
}