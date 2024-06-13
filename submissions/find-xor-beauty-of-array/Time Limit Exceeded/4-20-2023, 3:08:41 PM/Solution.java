// https://leetcode.com/problems/find-xor-beauty-of-array

class Solution {
     int xor = 0;
    public int xorBeauty(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, list, curr);
        
        return xor;
    }
    
    private void helper(int[] nums, List<List<Integer>> list, List<Integer> curr){
        if(curr.size()==3){
            int val = ((curr.get(0) | curr.get(1)) & curr.get(2));
            xor ^= val;
            return;
        }
        
        for(int n : nums){
            curr.add(n);
            helper(nums, list, curr);
            curr.remove(curr.size()-1);
        }
    }
    
}