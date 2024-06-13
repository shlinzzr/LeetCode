// https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Set<List<Integer>> res = new HashSet<>();
        
        helper(nums, new ArrayList<>(), 0, res);
        
        return new ArrayList<>(res);
    }
    
    
    private void helper(int[] nums, List<Integer> curr, int st,  Set<List<Integer>> res ){
        res.add(new ArrayList<>(curr));
        
        for(int i=st; i<nums.length; i++){
            
            curr.add(nums[i]);
            helper(nums, curr, i+1, res);
            curr.remove(curr.size()-1);
        }
    }
}