// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> res= new HashSet<>();
        
        helper(nums, new ArrayList<>(), 0, res);
        
        return new ArrayList<>(res);
    }
    
    private void helper(int[] nums, List<Integer> list, int st, Set<List<Integer>> res){
        
        res.add(new ArrayList<>(list));
        
        for(int i=st; i<nums.length; i++){
            int n = nums[i];
            list.add(n);
            helper(nums, list, i+1, res);
            list.remove(list.size()-1);
        }
    }
}