// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();
        helper(candidates, target, new ArrayList<>(), res, 0);
        return new ArrayList<>(res);
    }

    private void helper(int[] candidates, int target, List<Integer> curr, Set<List<Integer>> res, int st){

        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=st; i<candidates.length; i++){
            int c = candidates[i];
            if(target>=c){
                curr.add(c);
                helper(candidates, target-c, curr, res, i+1);
                curr.remove(curr.size()-1);
            }
        }
        
    }
}