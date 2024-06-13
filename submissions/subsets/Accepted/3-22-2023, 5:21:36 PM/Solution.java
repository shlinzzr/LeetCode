// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        
        helper(nums, new ArrayList<>(), set, 0);
        
        return new ArrayList<>(set);
        
    }
    
    private void helper(int[] nums, List<Integer> curr,   Set<List<Integer>> set, int st){
        
        set.add(new ArrayList<>(curr));
        
        for(int i=st; i<nums.length; i++){
            curr.add(nums[i]);
            helper(nums, curr, set, i+1);
            curr.remove(curr.size()-1);
        }
    }
}