// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        helper(set, nums, new ArrayList<>(), 0);
        
        return new ArrayList<>(set);
    }
    
    private void helper(Set<List<Integer>> set, int[] nums, List<Integer> list, int st){
        
        set.add(new ArrayList<>(list));
        
        for(int i=st; i<nums.length; i++){
            list.add(nums[i]);
            helper(set, nums, list, i+1);
            list.remove(list.size()-1);
        }
        
    }
}