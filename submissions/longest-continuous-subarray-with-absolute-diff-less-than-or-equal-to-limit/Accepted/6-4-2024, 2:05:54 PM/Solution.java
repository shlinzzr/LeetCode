// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        int len = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>(); // val, cnt
        
        int st = 0, ed;
        for (ed = 0; ed < len; ed++) {
            map.put(nums[ed], 1 + map.getOrDefault(nums[ed], 0));

            if (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[st], map.get(nums[st]) - 1);
                if (map.get(nums[st]) == 0)
                    map.remove(nums[st]);
                st++;
            }
        }
        return ed-st;


        
    }
}