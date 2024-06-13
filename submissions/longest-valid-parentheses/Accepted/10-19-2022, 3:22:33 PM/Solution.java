// https://leetcode.com/problems/longest-valid-parentheses

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int ret = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') 
                stack.push(i);            
            else {
                if(!stack.isEmpty() && s.charAt(stack.peek())=='('){
                    stack.pop();
                    ret = Math.max(ret, i - (stack.isEmpty() ? -1 : stack.peek()));
                }else{
                    stack.push(i);
                }
            }
        }
        return ret;
    }
    
    //匯豐我大哥
}