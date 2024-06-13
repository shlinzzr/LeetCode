// https://leetcode.com/problems/largest-number-at-least-twice-of-others

class Solution {
    public int dominantIndex(int[] nums) {
        int len = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        
        for(int i=len-1; i>0; i--){
            
            if(nums[i]>=2*nums[i-1])
                return map.get(nums[i]);
        }
        return -1;
        
    }
}