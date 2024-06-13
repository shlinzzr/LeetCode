// https://leetcode.com/problems/make-sum-divisible-by-p

class Solution {
    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        
        int total = 0;
        for(int n: nums) total +=n;
        int target = total%p;
        
        if(target==0)
            return 0;
        
        
        // find min j-i==mod p        
        
        int min = len;
        
        int presum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        // X x x [x x x] x x x
        //.    i      j.     k
        
        // (p[k] - (p[j]-p[i]) )%p ==0
        
        for(int i=0; i<len; i++){
            
            presum += nums[i];
            
            int mod = (presum-target+p)%p;
            
            if(map.containsKey(mod)){
                min = Math.min(min, i-map.get(mod));
            }
            
            map.put(presum%p, i);
        }
        
        return min;
        
    }
}