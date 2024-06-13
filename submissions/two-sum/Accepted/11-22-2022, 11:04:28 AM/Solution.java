// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            
            if(!map.containsKey(target-n)){
                map.put(n, i);
                
            }else{
                
                return new int[]{i, map.get(target-n)};
            }
        }
        
        return new int[2];
    }
}