// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            
            if(ch=='(' || ch=='[' || ch=='{')
                st.push(ch);
            
            else if(ch==')' && (st.isEmpty() || st.peek()!='('))
                return false;
            else if(ch==']' && (st.isEmpty() || st.peek()!='['))
                return false;
            else if(ch=='}' && (st.isEmpty() || st.peek()!='{'))
                return false;
            else st.pop();
            
            
        }
        
        return st.isEmpty();
    }
}