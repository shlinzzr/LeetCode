// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {

        int len = nums.length;
        int st = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int[] presum = new int[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0 ? nums[i] : nums[i] + presum[i-1];

            if(map.containsKey(presum[i]-k)){
                res+= map.get(presum[i]-k);
            }

            map.put(presum[i], map.getOrDefault(presum[i],0) +1);
        }

        return res;
            
        
    }
}