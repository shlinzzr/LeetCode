// https://leetcode.com/problems/continuous-subarray-sum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int len = nums.length;

        Set<Integer> set = new HashSet<>();
        boolean hitZero = false;

        int sum = 0 ;
        for(int i=0; i<len; i++){
            sum += nums[i];
            sum %=k;


            if(sum==0){
                if(hitZero) return true;
                hitZero = true;
            }

            if(set.contains(sum)){
                return true;
            }else
                set.add(sum);

        }

        return false;

        
    }
}