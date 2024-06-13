// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }

    private void helper(int[] candidates, int target, List<Integer> curr, List<List<Integer>> res, int st){

        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=st; i<candidates.length; i++){
            int c = candidates[i];
            if(target>=c){
                curr.add(c);
                helper(candidates, target-c, curr, res, i);
                curr.remove(curr.size()-1);
            }
        }

    }
}