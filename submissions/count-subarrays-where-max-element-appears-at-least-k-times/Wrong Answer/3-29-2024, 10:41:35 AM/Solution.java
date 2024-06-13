// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times

class Solution {
    public long countSubarrays(int[] nums, int k) {

        long res = 0;
        int len = nums.length;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int ed= 0;
        for(int st = 0; st<len; st++){

            while(ed<len && (map.isEmpty() || map.get(map.lastKey())<k)){
                map.put(nums[ed], map.getOrDefault(nums[ed],0)+1);
                ed++;
            }

            if(map.get(map.lastKey())>=k){
                res+=len-ed+1;
            }

            map.put(nums[st], map.get(nums[st])-1);
        }

        return res;
    }
}