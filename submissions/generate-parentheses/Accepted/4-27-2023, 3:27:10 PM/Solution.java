// https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper("", res, 0, 0, n);
        
        return res;
    }
    
    private void helper(String curr, List<String> res, int left, int right, int n){
        
        if(left==n && right==n){
            res.add(curr);            
            return ;
        }
            
        
        if(left<n){
            helper(curr+"(", res, left+1, right, n);
        }
        
        if(right<left)
            helper(curr+")", res, left, right+1, n);
    } 
}