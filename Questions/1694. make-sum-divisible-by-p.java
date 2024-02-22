// https://leetcode.com/problems/make-sum-divisible-by-p

class Solution {
    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        
        long total = 0;
        for(int n: nums) total +=n; //10
        long target = total%p; // 4
        if(target==0)
            return 0;
        
        int min = len; //4
        
        long presum = 0;
        
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L,-1);
        for(int i=0; i<len; i++){
            
            presum += nums[i]; //3, 4, 8
            
            long mod = (presum-target+p)%p; //3-4+6==5, 4-4+6, 8-4+6==4
            
            if(map.containsKey(mod)){
                min = Math.min(min, i-map.get(mod)); //1--1==2, 1, 
            }
            
            // System.out.println(i + " presum="+ presum + " mod="+mod + " min="+ min + " bool="+(map.containsKey(mod))  );
            
            // System.out.println("map.put(" +(presum%p) + ", "+ i + ")");
            map.put( (presum%p), i); //[3,0] [4,1]
        }
        
        return min==len? -1 : min;
        
    }
    
    
    
    
    
     // X x x [x x x] x x x
        //.    i      j.     k
        
        // (p[k] - (p[j]-p[i]) )%p ==0
          // find min j-i==mod p        
}