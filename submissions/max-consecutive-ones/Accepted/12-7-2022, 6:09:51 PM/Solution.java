// https://leetcode.com/problems/max-consecutive-ones

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max =0;
        int curr=0;
        for(int n : nums){
            if(n==0){
                max = Math.max(max, curr);
                curr=0;
            }else
            curr++;
        }
max = Math.max(max, curr);
        return max;
    }
}