// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0; i<nums.length; i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                
                  return new int[]{map.get(comp) , i};   
                
            }
            map.put(nums[i], i);
            
            
        }
      throw new IllegalArgumentException("No two sum solution");
    }
}