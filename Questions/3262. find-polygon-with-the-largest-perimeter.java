// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter

class Solution {
    public long largestPerimeter(int[] nums) {
        int len = nums.length;
        long[] presum = new long[len];

        Arrays.sort(nums);

        for(int i=0; i<len; i++){
            presum[i] = i==0? nums[0] : nums[i]+presum[i-1];
        }

        for(int i=len-1; i>0; i--){

            if(nums[i]<presum[i-1]){
                return presum[i];
            }

        }

        return -1;
    
    }
}