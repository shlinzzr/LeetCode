// https://leetcode.com/problems/binary-subarrays-with-sum

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int presum = 0 ;

        int res = 0;
        for(int i=0; i<len; i++){

            presum += nums[i];
            res += map.getOrDefault(presum-goal, 0);
            map.put(presum, map.getOrDefault(presum,0)+1);
        }

        return res;

        
    }
}