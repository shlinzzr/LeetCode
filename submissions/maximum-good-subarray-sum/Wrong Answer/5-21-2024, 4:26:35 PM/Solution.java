// https://leetcode.com/problems/maximum-good-subarray-sum

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        int len = nums.length;

        Map<Long, Integer> map = new HashMap<>(); // presum , idx
        int[] presum = new int[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0 ? nums[i] : presum[i-1] + nums[i];
        }

        map.put(0L, -1);
        long sum =0, res = 0;
        for(int i=0; i<len; i++){

            sum += nums[i];
            
            if(map.containsKey(sum-k)){

                if(map.get(sum-k)==-1 || map.get(sum-k)-1==-1)
                    res = Math.max(res, sum);
                else
                    res = Math.max(res, sum-presum[map.get(sum-k)-1]);
            }

            if(map.containsKey(sum+k)){

                if(map.get(sum+k)==-1 || map.get(sum+k)-1==-1)
                    res = Math.max(res, sum);
                else
                    res = Math.max(res, sum-presum[map.get(sum+k)-1]);
            }


            if(!map.containsKey(sum) || sum< presum[map.get(sum)] )
                map.put(sum , i);
        }

        return res;
        
    }
}