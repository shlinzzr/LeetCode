// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
        int cnt=0;
        
        Stack<Integer> st = new Stack<>();
        
        int max=0;
        for(int i=0; i<s.length();i++){
            
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(i);
            }else{ //ch==')'
                
                if(!st.isEmpty() && s.charAt(st.peek())=='('){
                    st.pop();
                    max = Math.max(max, i-(st.isEmpty()? -1 : st.peek()));
                }else{
                    st.push(i);
                }
            }
        }
        
        
        return max;
    }
}