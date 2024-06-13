// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        
        for(int i=1; i<len; i++){
            nums[i] += nums[i-1];
        }
        // for(int i=0; i<len; i++){
        //     System.out.println(nums[i]);
        // }
        
        int min = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i=0; i<len; i++){
            map.put(nums[i], i);
            
            Integer key = map.floorKey(nums[i]-target+1);
            if(key!=null)
                min = Math.min(min, i-map.get(key));
        }
        
        return min==Integer.MAX_VALUE ? 0 : min;
            
    
    }
}