// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {

        int len = nums.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int presum = 0 ;
        // int[] presum = new int[len];
        for(int i=0; i<len; i++){
            // presum[i] = i==0 ? nums[i] : nums[i] + presum[i-1];
            presum = i==0 ? nums[i] : presum + nums[i];

            if(map.containsKey(presum-k)){
                res+= map.get(presum-k);
            }

            map.put(presum, map.getOrDefault(presum,0) +1);
        }

        return res;
            
        
    }
}