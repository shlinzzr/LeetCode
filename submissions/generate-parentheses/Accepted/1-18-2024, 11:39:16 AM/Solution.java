// https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        helper(n, 0, 0, res, "");
        
        return res;
    }
    
    private void helper(int n, int left, int right, List<String> res, String s){
        
        if(right==n) {
            res.add(s);
            return;
        }
        
        if(left<n)
            helper(n, left+1, right, res, s+"(");
        
        if(right<left){
            helper(n, left, right+1, res, s+")");
        }
        
    }
}