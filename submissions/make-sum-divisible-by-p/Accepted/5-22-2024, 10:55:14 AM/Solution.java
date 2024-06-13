// https://leetcode.com/problems/make-sum-divisible-by-p

class Solution {
    public int minSubarray(int[] nums, int p) {

        // pre-condition

        long sum = 0 ;
        for(int n : nums)
            sum += n;
        long target = sum%p;
        if(target==0) return 0;




        int len = nums.length;
        Map<Long, Integer> map = new HashMap<>(); // sum, idx
        map.put(0L, -1);
        int res = len;

        long[] presum = new long[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0 ? nums[i] : presum[i-1] + nums[i];

            // 這裡我們要找的是target跟presum[i] diff的 mod

            long mod =  (presum[i]-target+p)%p;
            if(map.containsKey(mod)){
                res = Math.min(res, i-map.get(mod));
            }

            map.put(presum[i]%p, i);
        }
        return res == len ? -1 : res;

        
    }
}