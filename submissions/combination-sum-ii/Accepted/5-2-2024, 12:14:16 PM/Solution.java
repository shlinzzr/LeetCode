// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();

        boolean[] used = new boolean[candidates.length];
        helper(candidates, target, new ArrayList<>(), res, 0, used);
        return new ArrayList<>(res);
    }

    private void helper(int[] candidates, int target, List<Integer> curr, Set<List<Integer>> res, int st, boolean[] used){

        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=st; i<candidates.length; i++){

            if(!curr.isEmpty() && candidates[i]==curr.get(curr.size()-1) && used[i-1]==false && i<candidates.length){
                continue;
            }

            int c = candidates[i];
            if(target>=c){
                used[i] = true;
                curr.add(c);
                helper(candidates, target-c, curr, res, i+1, used);
                curr.remove(curr.size()-1);
                used[i] = false;
            }
        }
        
    }
}