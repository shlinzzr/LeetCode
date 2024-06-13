// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         Set<List<Integer>> res = new HashSet<>();
        helper(nums, res, new ArrayList<>(), 0);
        
        return new ArrayList<>(res);
    }
    
    private void helper(int nums[],  Set<List<Integer>> res , List<Integer> list , int st){
        res.add(new ArrayList<>(list));
        
        for(int i=st; i<nums.length; i++){
            
            list.add(nums[i]);
            helper(nums, res, list, i+1);
            list.remove(list.size()-1);
            
        }
        
    }

}