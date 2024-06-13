// https://leetcode.com/problems/make-sum-divisible-by-p

class Solution {
    public int minSubarray(int[] nums, int p) {

        // pre-condition

        long sum = 0 ;
        for(int n : nums)
            sum += n;
        long offset = sum%p;
        if(offset==0) return 0;

        int len = nums.length;
        Map<Long, Integer> map = new HashMap<>(); // sum, idx
        map.put(0L, -1);
        int res = len;

        long[] presum = new long[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0 ? nums[i] : presum[i-1] + nums[i];

            long mod =  (presum[i]-offset+p)%p;  // +p to avoid negative mod

            // (presum[i]-offset)%p == presum[j] 如果有在map內找到 
            // 表示 presum[i]-presum[j] 這段中間的subarray 包含了 offset
            //去掉中間這段 表示前後都可以被p 整除 
            // => x x x x [x x x x ]  x x x x 
            //          j        i 
            // presum[i] = presum[j] + offset => find( presum[i]-offset )

            if(map.containsKey(mod)){
                res = Math.min(res, i-map.get(mod));
            }

            map.put(presum[i]%p, i);
        }
        return res == len ? -1 : res;

        
    }
}