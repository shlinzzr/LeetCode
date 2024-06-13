// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        int len = nums.length;
        
        List<List<Integer>> res = new ArrayList<>();
        
        boolean[] seen = new boolean[len];
        
        helper(nums, new ArrayList<>(), res, seen);
            
        return res;
    }
    
    
    private void helper(int[] nums, List<Integer> curr, List<List<Integer>> res, boolean[] seen){
        
        int len = nums.length;
        
        if(curr.size()==len){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=0; i<len; i++){
            
            if(seen[i]==false){
                seen[i]=true;
                curr.add(nums[i]);
                helper(nums, curr, res, seen);
                curr.remove(curr.size()-1);
                seen[i]=false;
            }
        }
        
    }
}