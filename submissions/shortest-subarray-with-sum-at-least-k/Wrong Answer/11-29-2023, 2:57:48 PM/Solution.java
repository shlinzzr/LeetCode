// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        long[] presum = new long[len+1];

        for(int i=0; i<len; i++){
            presum[i+1] =  nums[i] + presum[i];
        }

        int min= Integer.MAX_VALUE;
        int st = 0;
        for(int ed=1; ed<=len; ed++){
            if(presum[ed]-presum[st]<k){
                continue;
            }

            min = Math.min(min, ed-st);

            while(presum[ed]-presum[st]>=k){
                st++;
            }

        }

        return min==Integer.MAX_VALUE ? -1 : min;
    }
}