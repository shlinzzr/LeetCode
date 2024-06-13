// https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        
        helper(res, "", 3, 3);
        
        return res;
    }
    
    private void helper(List<String> res, String curr, int left, int right){
        
        if(left==0 && right==0){
            res.add(curr);
        }
        
        if(left>0){
            helper(res, curr+"(", left-1, right);
        }
        
        if(right>0 && right>left){
            helper(res, curr+")", left, right-1);
        }
    }
}