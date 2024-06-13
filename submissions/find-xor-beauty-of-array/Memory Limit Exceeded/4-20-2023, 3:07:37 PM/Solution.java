// https://leetcode.com/problems/find-xor-beauty-of-array

class Solution {
    public int xorBeauty(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, list, curr);
        
        int xor=0;
        
        for(List<Integer> sub: list){
            
            int val = ((sub.get(0) | sub.get(1)) & sub.get(2));
            xor ^= val;
        }
        return xor;
    }
    
    private void helper(int[] nums, List<List<Integer>> list, List<Integer> curr){
        if(curr.size()==3){
            list.add(new ArrayList<>(curr));
            return;
        }
        
        for(int n : nums){
            curr.add(n);
            helper(nums, list, curr);
            curr.remove(curr.size()-1);
        }
    }
    
}