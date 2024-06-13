// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int st =0;
        for(int ed=0; ed<nums.length; ed++){
            map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
            while(st<=ed && map.get(nums[ed])>k){
                map.put(nums[st], map.get(nums[st])-1);
                st++;
            }

            max = Math.max(max, ed-st+1);
        }

        return max;
        
    }
}