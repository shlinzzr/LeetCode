// https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target

class Solution {
    public int maxNonOverlapping(int[] nums, int target) {

        int len = nums.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<len; i++){
            sum += nums[i];

            if(map.containsKey(sum-target)){
                res++;
                map = new HashMap<>();
                sum=0;
            }

            map.put(sum , map.getOrDefault(sum, 0)+1);
        }

        return res;
        
    }
}