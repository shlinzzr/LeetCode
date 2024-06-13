// https://leetcode.com/problems/maximum-good-subarray-sum

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> map = new HashMap<>(); // nums[i], min_presum
        long sum = 0;
        long res = Long.MIN_VALUE;

        for (int v : nums) {
            if (map.containsKey(v - k)) {
                long min = map.get(v - k);
                res = Math.max(res, v + sum-min);
            }
            if (map.containsKey(v + k)) {
                long min = map.get(v + k);
                res = Math.max(res, v + sum-min);
            }

            map.put(v, Math.min(map.getOrDefault(v, Long.MAX_VALUE), sum));
            sum += v;
        }

        return res == Long.MIN_VALUE ? 0 : res;
    }
}