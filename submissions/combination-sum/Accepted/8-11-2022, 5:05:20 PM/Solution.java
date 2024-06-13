// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, res, new ArrayList<>(), 0);
        
        return res;
        
        
        
    }
    
    
    private void helper(int[] can, int target, List<List<Integer>> list, List<Integer> curr, int start){
        
        if(target==0){
            list.add(new ArrayList<>(curr));
        }
        
        for(int i=start; i<can.length; i++){
            if(target-i>=0){
                curr.add(can[i]);
                helper(can, target-can[i], list, curr, i);
                curr.remove(curr.size()-1);
            }
        }
        
    }
    
    
}