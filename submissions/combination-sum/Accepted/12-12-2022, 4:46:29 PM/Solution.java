// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        helper(res, new ArrayList<>(), candidates, target, 0);
        return new ArrayList<>(res);
    }
    
    
    
    private void helper(Set<List<Integer>> res, List<Integer> curr, int[] candidates, int target, int st){
        
        if(target<0)
            return;
        
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        
        
        
        for(int i=st; i<candidates.length; i++){
            int can = candidates[i];
            
            if(target-can>=0){
                curr.add(can);
                helper(res, curr, candidates, target-can, i);
                curr.remove(curr.size()-1);
            }
        }
        
        
        
    }
}