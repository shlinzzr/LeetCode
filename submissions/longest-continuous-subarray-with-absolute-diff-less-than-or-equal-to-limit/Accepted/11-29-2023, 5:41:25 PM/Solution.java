// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;

        int max = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int st= 0;
        for(int i=0; i<len; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

            while(map.lastKey()-map.firstKey()>limit){
                map.put(nums[st], map.getOrDefault(nums[st], 0)-1);
                if(map.get(nums[st])==0)
                    map.remove(nums[st]);
                st++;
            }

            max = Math.max(max, i-st+1);
        }

        return max;

        

    }
}