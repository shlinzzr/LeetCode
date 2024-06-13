// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int len = nums.length;
        
        for(int i=1; i<len; i++){
            nums[i] += nums[i-1];
        }
        
        int min = Integer.MAX_VALUE;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        for(int i=0; i<len; i++){
            
            map.put(nums[i], i);
            
            if(map.ceilingKey(nums[i]-target)!=null){
                min = Math.min(min, i-map.ceilingKey(nums[i]-target));
            }
            
        }
        
        return min==Integer.MAX_VALUE ? 0 : min;
            
        
        
    }
}