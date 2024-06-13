// https://leetcode.com/problems/make-sum-divisible-by-p

class Solution {
    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        
        long total = 0;
        for(int n: nums) total +=n;
        long target = total%p;
        if(target==0)
            return 0;
        
        
        // find min j-i==mod p        
        
        int min = len;
        
        long presum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        // X x x [x x x] x x x
        //.    i      j.     k
        
        // (p[k] - (p[j]-p[i]) )%p ==0
        
        for(int i=0; i<len; i++){
            
            presum += nums[i];
            
            long mod = (presum-target+p)%p;
            
            if(map.containsKey(mod)){
                min = Math.min(min, i-map.get(mod));
            }
            
            map.put((int) (presum%p), i);
        }
        
        return min==len? -1 : min;
        
    }
}