// https://leetcode.com/problems/count-subarrays-with-median-k

class Solution {
    public int countSubarrays(int[] nums, int k) {
        // <k:-1, ==k: 0, >k:1
        
        int len = nums.length;
        
        for(int i=0; i<len; i++){
            if(nums[i]<k)
                nums[i]=-1;
            else if(nums[i]==k)
                nums[i]=0;
            else
                nums[i]=1;
        }
        
        Map<Integer, Integer> oddSum = new HashMap<>();
        Map<Integer, Integer> evenSum = new HashMap<>();
        evenSum.put(0, 1);
        
        int presum = 0;
        int ret = 0;
        for (int i=0; i<nums.length; i++)
        {
            presum += nums[i];
            if (i%2==0)
            {
                ret += evenSum.getOrDefault(presum-0,0);
                ret += oddSum.getOrDefault(presum-1,0);
                oddSum.put(presum, oddSum.getOrDefault(presum, 0)+1);
            }
            else
            {
                
                ret += oddSum.getOrDefault(presum-0,0);
                ret += evenSum.getOrDefault(presum-1,0);
                evenSum.put(presum, evenSum.getOrDefault(presum, 0)+1);
            }
        }
        
        return ret;
        
        
        // [3,2,1,4,5] => [-1, -1, -1, 0, 1]
        //.     presum => [-1, -2, -3, -3, -2]
        // map : (0, -1)  
        
        // x x x x x [ x x x x ]
        //.            
        
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, 1);
        
//         int presum=0;
//         int res = 0;
        
//         for(int i=0; i<len; i++){
//             presum += nums[i];
            
//             res += map.getOrDefault(presum, 0);
            
//             map.put(presum, map.getOrDefault(presum,0)+1);
//         }
        
//         return res;
        
        
        
        
      
        
        
        
    }
}