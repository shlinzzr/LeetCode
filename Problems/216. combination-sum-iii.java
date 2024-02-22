// https://leetcode.com/problems/combination-sum-iii

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        
        helper(k, n, new ArrayList<>(), res, 1);
        
        return res;
    }
    
    
    private void helper(int k, int n, List<Integer> list, List<List<Integer>> res, int st){
        
        if(n<0)
            return;
        
        if(list.size()==k){
            if(n==0)
                res.add(new ArrayList<>(list));
        }
        
        for(int i=st; i<=9; i++){
            list.add(i);
            helper(k, n-i, list, res, i+1);
            list.remove(list.size()-1);
        }
        
    }
}