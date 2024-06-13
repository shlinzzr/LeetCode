// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(ch=='(' || ch=='[' || ch=='{')
                st.push(ch);
            
            else if(ch==')'){
                if(st.isEmpty() || st.peek()!='(')
                    return false;
                st.pop();
                
            }else if(ch==']'){
                if(st.isEmpty() || st.peek()!='[')
                    return false;
                st.pop();
                
            }else if(ch=='}'){
                if(st.isEmpty() || st.peek()!='{')
                    return false;
                st.pop();
            }
            
            
        }
        
        return st.isEmpty() ? true : false;
            
            
    }
}