// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses

class Solution {
    public String reverseParentheses(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> st = new Stack<>();

        for(int i=0; i<len; i++){
            char ch = s.charAt(i);

            if(ch=='('){
                st.push(sb);
                sb = new StringBuilder();
            }else if(ch==')'){

                StringBuilder tmp = new StringBuilder(sb);
                sb = st.pop();
                sb.append(tmp.reverse());
            }else{
                sb.append(ch);
            }

        }

        return sb.toString();

    }
}