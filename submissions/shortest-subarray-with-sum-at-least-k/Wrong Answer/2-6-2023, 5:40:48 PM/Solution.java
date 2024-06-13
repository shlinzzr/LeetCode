// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        
        int len = nums.length;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        
        for(int i=1; i<len;i++){
            nums[i]+=nums[i-1];
        }
        
        for(int i=0; i<len; i++){
            map.put(nums[i], i);
        }
        
        
        for(int i=0; i<len; i++){
         
            if(map.floorKey(nums[i]-k)!=null){
                // System.out.println(i +" " + min + " " + (map.floorKey(nums[i]-k)));
                
                min = Math.min(min, i-map.get(map.floorKey(nums[i]-k)));
            }
        }
        
        return min==Integer.MAX_VALUE ? -1 : min;
        
            
    }
}