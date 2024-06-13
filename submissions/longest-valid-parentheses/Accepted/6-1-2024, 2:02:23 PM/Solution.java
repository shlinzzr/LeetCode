// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        // (()
        // 012

        int len = s.length();
        int max = 0;

        for(int i=0; i<len; i++){

            char ch = s.charAt(i);
            if(ch=='('){
                st.push(i);
                
            }else if(ch==')'){
                
                st.pop();
                
                if(!st.isEmpty()){
                    max = Math.max(max, i-st.peek());
                }else{
                    st.push(i);
                }
                
            }


        }

        return max;
        
    }
}