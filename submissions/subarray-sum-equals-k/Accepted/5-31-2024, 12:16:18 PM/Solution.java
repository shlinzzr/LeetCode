// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {

        int len = nums.length;

        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res= 0 ;
        for(int i=0; i<len; i++){

            sum += nums[i];
            res += map.getOrDefault(sum-k, 0);
            map.put(sum , map.getOrDefault(sum, 0)+1);

        }

        return res;

        
    }
}