// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int len = nums.length;
        
        for(int i=1; i<len; i++){
            nums[i] += nums[i-1];
        }
        
        int min = len;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<len; i++){
            
            map.put(nums[i], i);
            
            if(map.containsKey(nums[i]-target)){
                min = Math.min(min, i-map.get(nums[i]-target));
            }
            
        }
        
        return min;
            
        
        
    }
}