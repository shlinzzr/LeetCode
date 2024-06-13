// https://leetcode.com/problems/combinations

class Solution {
    public List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> res = new ArrayList<>();
        
        helper(res, new ArrayList<>(), 1, n, k);
        return res;
        
    }
    
    private void helper( List<List<Integer>> res , List<Integer> list, int st, int n, int k){
        
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=st; i<=n;  i++){
            
            list.add(i);
            helper(res, list, i+1, n, k);
            list.remove(list.size()-1);
        }
        
    }
}