// https://leetcode.com/problems/continuous-subarray-sum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int len = nums.length;

        Set<Integer> set = new HashSet<>();
        int sum = 0 ;
        for(int i=0; i<len; i++){
            sum += nums[i];
            sum %=k;

            if(set.contains(sum)){
                return true;
            }else
                set.add(sum);

        }

        return false;

        
    }
}