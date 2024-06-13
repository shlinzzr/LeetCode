// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times

class Solution {
    public long countSubarrays(int[] nums, int k) {

        int max = 0;
        for(int n : nums){
            max = Math.max(max, n);
        }
            

        long res = 0;
        int len = nums.length;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int ed= 0;
        for(int st = 0; st<len; st++){

            while(ed<len &&  map.getOrDefault(max,0)<k){
                map.put(nums[ed], map.getOrDefault(nums[ed],0)+1);
                ed++;
            }

            if(map.getOrDefault(max,0)>=k){
                res+=len-ed+1;
            }
            // System.out.println(res);

            map.put(nums[st], map.get(nums[st])-1);
            if(map.get(nums[st])==0) map.remove(nums[st]);
        }

        return res;
    }
}