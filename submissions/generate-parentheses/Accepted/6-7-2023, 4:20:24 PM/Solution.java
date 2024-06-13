// https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", n, n);
        
        return res;
    }
    
    private void helper(List<String> res, String curr, int left, int right){
        
        if(left==0 && right==0){
            res.add(curr);
            return;
        }
        
        if(left>0){
            helper(res, curr+'(',left-1, right);
        }
        
        if(left<right && right>0){
            helper(res, curr+')', left, right-1);
        }
    }
}