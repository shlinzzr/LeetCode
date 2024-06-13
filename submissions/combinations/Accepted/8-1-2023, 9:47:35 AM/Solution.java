// https://leetcode.com/problems/combinations

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        helper(n, k, new ArrayList<>(), res, 1);
        return res;
    }
    
    private void helper(int n, int k, List<Integer> list, List<List<Integer>> res, int st){
        
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=st; i<=n; i++){
            list.add(i);
            helper(n, k, list, res, i+1);
            list.remove(list.size()-1);
        }
            
        
    }
}