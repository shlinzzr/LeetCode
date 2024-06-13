// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero

class Solution {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int presum = 0;
        
        for (int i=0; i<len; i++){
            presum += nums[i];
            if(!map.containsKey(presum)){
                map.put(presum, i);
            }
        }
        
        int ret = Integer.MAX_VALUE;
        
        if(map.containsKey(x)){
            ret = map.get(x)+1;
        }
        
        int sufsum = 0;
        for (int b = len-1; b>=0; b--)
        {
            sufsum += nums[b];
            int pre = x-sufsum;
            
            if(map.containsKey(pre)){
                int a = map.get(pre);
                if (a<b){ // a>=b : overlap is not allow
                    ret = Math.min(ret, a+1 + len-b); // head + tail
                }
            }
        }
        
        return ret== Integer.MAX_VALUE ? -1: ret;      
        
        
        
    }
}