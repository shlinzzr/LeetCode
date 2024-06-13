// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res= new ArrayList<>();

        helper(candidates, res, new ArrayList<>(), target, 0);
        return res;

    }

    private void helper(int[] arr,  List<List<Integer>> res, List<Integer> curr, int target, int st){

        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target<0)
            return;

        for(int i=st; i<arr.length; i++){
            
            if(target-arr[i]>=0){
                curr.add(arr[i]);
                helper(arr, res, curr, target-arr[i], i);
                curr.remove(curr.size()-1);
            }
        }


    }
}