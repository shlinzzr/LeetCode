// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), new HashSet<>(), res, 0);
        return res;
    }
    
    private void helper(int[]nums, List<Integer> curr, Set<Integer> seen, List<List<Integer>>  res, int  st){
        
        res.add(new ArrayList<>(curr));
        
        for(int i=st; i<nums.length; i++){
            if(seen.add(nums[i])==true){
                
                curr.add(nums[i]);
                helper(nums, curr, seen, res, i+1);
                curr.remove(curr.size()-1);
                seen.remove(nums[i]);
            }
        }
        
    }
}