// https://leetcode.com/problems/ways-to-split-array-into-three-subarrays

class Solution {
    public int waysToSplit(int[] nums) {

        left <= mid <= right

        int M = (int) 1e9+7;
        int len = nums.length;
        int[] presum = new int[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0 ? nums[i] : nums[i] + presum[i-1];
        }

        [ x x x ] [ x x] [x x x] 
              i       j       k

        // find p[j]>=2*p[i] && p[len-1] >= 2*p[j];
        // find p[k] > 4*p[i];
        // p[j] >= 2*p[i],
        // p[k] >= 2*p[j]


        for(int i=0; i<len; i++){
            
        }



        
    }
}