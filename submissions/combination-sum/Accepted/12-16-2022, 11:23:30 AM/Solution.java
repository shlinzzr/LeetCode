// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>>  res = new HashSet<>();
        helper(res, new ArrayList<>(), candidates, target, 0);
        return new ArrayList<>(res);
        
    }
    
    private void helper(Set<List<Integer>> res , List<Integer> curr, int[] can, int target, int st){
        
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        
        for(int i=st; i<can.length; i++){
            
            if(can[i]<=target){
                curr.add(can[i]);
                helper(res, curr, can, target-can[i], i);
                curr.remove(curr.size()-1);
            }
        }
        
    }
}