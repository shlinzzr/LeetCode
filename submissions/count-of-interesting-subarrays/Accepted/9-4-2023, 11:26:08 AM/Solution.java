// https://leetcode.com/problems/count-of-interesting-subarrays

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long res = 0;
        int cnt = 0;
        map.put(0, 1);

        for (int n : nums) {
            if (n % modulo == k) {
                cnt++;
            }
            res += map.getOrDefault((cnt - k + modulo) % modulo, 0);
            map.put(cnt % modulo, map.getOrDefault(cnt % modulo, 0) + 1);
        }

        return res;
    }
}