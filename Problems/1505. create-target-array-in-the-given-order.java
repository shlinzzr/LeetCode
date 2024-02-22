// https://leetcode.com/problems/create-target-array-in-the-given-order

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            
            list.add(index[i], nums[i]);
            
            
        }
        
        
        int[] target = new int[nums.length];
        for(int i=0; i<nums.length; i++){
         
            target[i] = list.get(i);
        }
        
        return target;
        
    }
    
}