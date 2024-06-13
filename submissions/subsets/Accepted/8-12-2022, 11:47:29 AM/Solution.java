// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res =new ArrayList<>();
        helper(nums, res, new ArrayList<>(), 0);
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int start){
        
        res.add(new ArrayList<>(list));

        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            helper(nums, res, list, i+1);
            list.remove(list.size()-1);
        }
        
        
        
    }
}