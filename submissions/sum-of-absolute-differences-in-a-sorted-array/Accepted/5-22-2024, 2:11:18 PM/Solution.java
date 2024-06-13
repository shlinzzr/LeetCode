// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int len = nums.length;
        int[] res = new int[len];

        int[] presum = new int[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0 ? nums[i] : presum[i-1]+nums[i];
        }

        int[] sufsum = new int[len];
        for(int i=len-1; i>=0; i--){
            sufsum[i] = i==len-1 ? nums[i] : sufsum[i+1] + nums[i];
        }

        // nums : non-desc
        //  1 1 2 3 4

        // nums 2 3 5
        // diff 0 1 3 => ans = 4
        // pre  2 5 10
        // suf 10 8  5
        

        for(int i=0; i<len; i++){
            res[i] = ((nums[i] * i) - presum[i]) + (sufsum[i] - (nums[i] * (len - i - 1)));
        }

        return res;



        
    }
}