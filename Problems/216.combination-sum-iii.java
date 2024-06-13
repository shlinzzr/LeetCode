// https://leetcode.com/problems/combination-sum-iii

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res= new ArrayList<>();

        helper(k, n, new ArrayList<>(), res, 1);

        return res;
    }

    private void helper(int k, int n, List<Integer> curr, List<List<Integer>> res, int idx){

        if(n==0 && k==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(k==0 || n<=0) return;


        for(int i= idx; i<=9; i++){
            curr.add(i);
            helper(k-1, n-i, curr, res, i+1);
            curr.remove(curr.size()-1);
        }
    }

}