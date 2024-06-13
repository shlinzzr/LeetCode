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
        
        // find
        // [-1, 0, 1]   odd length, sum=0
        // [-1, 0, 1, 1] even length sum=1
        
        
        Map<Integer, Integer> oddSum = new HashMap<>();
        Map<Integer, Integer> evenSum = new HashMap<>();
        evenSum.put(0, 1);
        
        int presum = 0;
        int res = 0;
        for (int i=0; i<nums.length; i++)
        {
            presum += nums[i];
            if (i%2==0) // odd length
            {   
                // 0 1.  2 3 4
                // x x [ x x x]
                //   j       i
                // find evenSum 0
                res += evenSum.getOrDefault(presum,  0);
                
                
                // 0 1 2  3 4
                // x x x[ x x]
                //     j    i
                // find oddSum 1
                res +=  oddSum.getOrDefault(presum-1, 0);
                oddSum.put(presum, oddSum.getOrDefault(presum, 0)+1);
                
                
            } else{ // even length
                
                // 0 1 2.  3 4 5
                // x x x [ x x x]
                //             i
                // find oddSum 1
                
                res +=  oddSum.getOrDefault(presum,  0);
                res += evenSum.getOrDefault(presum-1,0);
                evenSum.put(presum, evenSum.getOrDefault(presum, 0)+1);
            }
        }
        
        return res;
        
        
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