// https://leetcode.com/problems/remove-outermost-parentheses

class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack();
        int start=0;
        
        String res = "";
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            if(c=='('){
                st.push(c);
            }else
                st.pop();
            
            if(st.isEmpty())
                if(start+1<i){
                    res += s.substring(start+1, i);
                    start = i+1;
                }
            
        }
        
        return res;
    }
}