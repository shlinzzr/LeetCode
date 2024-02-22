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
        
        // 分析 更換的k可能落在前半段或後半段
        // x x x x x x [ x x k x x ] //假設更換的i在後半段
        long[] rets = new long[len]; //代表更換第i個num時的答案
        for (int i=0; i<len; i++){
            long new_sum = sum + k-nums[i];
            if (new_sum % 2 == 0)
                rets[i] += count.getOrDefault(new_sum/2, 0); 
            
            //填入org presum
            count.put(pre[i], count.getOrDefault(pre[i],0)+1);
        }
        count.clear();
        
        // [x x x k x x] x x x x x  //倒過來 假設更換的i在前半段
        for (int i=len-1; i>=0; i--)
        {
            long new_sum = sum + k-nums[i];
            if (new_sum % 2 == 0)
                rets[i] += count.getOrDefault(new_sum/2, 0);
            
            //填入org sufsum
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