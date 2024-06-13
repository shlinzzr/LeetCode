// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        
        
        for(char ch: s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
                
            }else if(st.size()<0)
                return false;
            
            else if(ch==')'){
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
        
        
        if(st.size()>0)
            return false;
        
        return true;
        
    }
}