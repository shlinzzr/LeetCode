// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] res =new int[2];
        
        HashMap<Integer, Integer> map = new HashMap<>(); // val, key
        
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            if(map.containsKey(target-n)){
                res[0] = map.get(target-n);
                res[1] = i;
            }
            
            map.put(n, i);
                
            
        }
        
        return res;
        
    }
}