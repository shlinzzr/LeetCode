// https://leetcode.com/problems/sum-of-subarray-ranges

class Solution {
    public long subArrayRanges(int[] nums) {

        int len = nums.length;

        // bf
            
        int res = 0 ;
        for(int i=0; i<len; i++){

            int min = nums[i];
            int max = nums[i];

            for(int j=i+1; j<len; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                res += max-min;
            }
        }

        return res;



        
    }
}