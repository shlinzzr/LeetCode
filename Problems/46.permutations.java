// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        helper(nums, new HashSet<>(), new ArrayList<>(), res);
        
        return res;
    }
    
    private void helper(int[] nums, Set<Integer> seen, List<Integer> curr, List<List<Integer>> res){
        
        if(curr.size()==nums.length){
            res.add( new ArrayList<>(curr));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(seen.contains(nums[i]))
                continue;
            curr.add(nums[i]);
            seen.add(nums[i]);
            helper(nums, seen, curr, res);
            curr.remove(curr.size()-1);
            seen.remove(nums[i]);
        }
        
    }
}