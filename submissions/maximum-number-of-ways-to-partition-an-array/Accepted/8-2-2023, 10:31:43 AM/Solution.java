// https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array

class Solution {
    public int waysToPartition(int[] nums, int k) {
        // x x x x [x x x x]
        //      i-1 i     k
        // p[k]-p[i-1]=p[i-1]
        // ==> p[k] = 2p[i-1]
//         int res = 0;
//         int len = nums.length;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int presum = 0;
        
//         for(int i=0; i<len; i++){
//             presum += nums[i];
            
//             if(presum%2==0){
//                 res += map.getOrDefault(presum/2, 0);
//             }
            
            
//             map.put(presum,  map.getOrDefault(presum, 0)+1);
//         }
        
        int len = nums.length;
        
        long[] rets = new long[len];
        
        long[] pre = new long[len];
        pre[0] = nums[0];
        for (int i=1; i<len; i++)
            pre[i] = pre[i-1]+nums[i];        
        
        long[] suf = new long[len];
        suf[len-1] = nums[len-1];
        for (int i=len-2; i>=0; i--)
            suf[i] = suf[i+1]+nums[i];        
        
        long sum = 0;
        for(int n : nums){
            sum+=n;
        }
        
        
        Map<Long, Integer> count = new HashMap<>();
        for (int i=0; i<len; i++){
            long new_sum = sum + k-nums[i];
            if (new_sum % 2 == 0)
                rets[i] += count.getOrDefault(new_sum/2, 0);
            count.put(pre[i], count.getOrDefault(pre[i],0)+1);
        }
        count.clear();
        
        for (int i=len-1; i>=0; i--)
        {
            long new_sum = sum + k-nums[i];
            if (new_sum % 2 == 0)
                rets[i] += count.getOrDefault(new_sum/2, 0);
            count.put(suf[i], count.getOrDefault(suf[i],0)+1);
        }         
        
        long ret = 0;
        for (int i=0; i<len-1; i++)
        {
            if (pre[i]==sum-pre[i])
                ret++;
        }
        
        for (int i=0; i<len; i++)
            ret = Math.max(ret, rets[i]);
        
        return (int)ret;        
        
        
        
    }
}