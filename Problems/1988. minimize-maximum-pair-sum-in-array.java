// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array

class Solution {
    public int minPairSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int max = 0;
        for(int i=0; i<len; i++){
            max = Math.max(max, nums[i]+ nums[len-1-i]);
        }

        return max;
    }
}

/*
 2 3 4 4 5 6

 1 1 1 2 4 4 5 5 5 5

 */