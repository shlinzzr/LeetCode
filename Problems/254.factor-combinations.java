// https://leetcode.com/problems/factor-combinations

class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(n==1)
            return res;
        
        helper(res, new ArrayList<>(), 2, n);
        
        if(res.size()>0)
            res.remove(res.size()-1);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, ArrayList<Integer> curr, int st, int n){
        if(n==1){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=st; i<=n; i++){
            
            if(n%i==0){
                curr.add(i);
                helper(res, curr, i, n/i);
                curr.remove(curr.size()-1);
            }
        }
    }
}