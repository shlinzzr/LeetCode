// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            
            if(ch=='(' || ch=='[' || ch=='{') {
                st.push(ch);
            }else if(ch==')'){
                
                if(st.pop()!='(')
                    return false;
                
            }else if(ch==']'){
                
                if(st.pop()!='[')
                    return false;
            }else if(ch=='}'){
                
                if(st.pop()!='{')
                    return false;
                
            }
            
        }
        
        
        return st.isEmpty();
    }
}