// https://leetcode.com/problems/binary-subarrays-with-sum

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length;
        // int[] presum = new int[len];

        // for(int i=0; i<len; i++){
        //     presum[i] = i==0 ? nums[i] : presum[i-1] + nums[i];
        // }
        int res = 0;
        int sum = 0;
        int st= 0;
        for(int ed=0; ed<len; ed++){

            sum+= nums[ed];
            if(sum<=goal){
                if(sum==goal) res++;
                continue;
            } 

            while(sum>=goal){
                
                sum -= nums[st];
                st++;

                if(sum==goal){
                    res++;
                }
            }
        }

        return res;

    }
}