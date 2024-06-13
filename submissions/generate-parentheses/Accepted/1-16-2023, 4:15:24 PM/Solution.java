// https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        
        helper(res, "", 0, 0, n);
        
        return res;
        
        
    }
    
    
    private void helper(List<String> res, String curr, int left, int right,  int n){
        
        if(curr.length()==2*n){
            res.add(curr);
            return;
        }
        
        if(left<n){
            helper(res, curr+"(", left+1, right, n);
        }
        
        if(right<left && right<n){
            helper(res, curr+")", left, right+1, n);
        }
        
        
        
    }
}
