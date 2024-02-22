// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] C, int target) {
        
        Arrays.sort(C);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, C, target, new ArrayList<>(), 0);
        return res;
        
    }
    
    
    private void helper(List<List<Integer>> res , int[] C, int target, List<Integer>curr, int st){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return ;
        }
        
        if(target<0)
            return;
        
        
        for(int i=st; i<C.length; i++){
            int n = C[i];
            curr.add(n);
            helper(res, C, target-n, curr, i);
            curr.remove(curr.size()-1);
        }
    }
}