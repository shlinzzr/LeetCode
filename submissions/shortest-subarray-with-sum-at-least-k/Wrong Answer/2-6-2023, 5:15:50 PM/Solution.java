// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        
        int len = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i=1; i<len;i++){
            nums[i]+=nums[i-1];
            map.put(nums[i], i);
           
        }
        
        for(int i=0; i<len; i++){
            
            if(map.containsKey(nums[i]-k)){
                min = Math.min(min, i-map.get(nums[i]-k));
            }
        }
        
        return min==Integer.MAX_VALUE ? -1 : min;
        
            
    }
}