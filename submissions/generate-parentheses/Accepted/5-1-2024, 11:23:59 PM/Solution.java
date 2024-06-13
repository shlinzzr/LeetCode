// https://leetcode.com/problems/generate-parentheses

class Solution {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        StringBuilder sb = new StringBuilder();
        helper(n, 0 ,0, sb);

        return res;
        
    }

    private void helper(int n, int left, int right, StringBuilder sb){

        if(left==n && right==n){
            res.add(sb.toString());
            return;
        }

        if(right<left){
            sb.append(")");
            helper(n ,left, right+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(left<n){
            sb.append("(");
            helper(n ,left+1, right, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}