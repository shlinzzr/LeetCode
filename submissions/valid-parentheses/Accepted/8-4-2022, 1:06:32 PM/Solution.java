// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
       
        
        
        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }else {
                if(st.isEmpty())
                    return false;
                else{
                    char cr =   st.pop();
                    
                    if ( (cr=='(' && c==')')
                      || (cr=='{' && c=='}')
                      || (cr=='[' && c==']')){
                        
                        continue;
                        
                      
                    }else
                        return false;
              }
            } 
         }
        
        if(!st.isEmpty())
            return false;
        
        return true;
    }
    
    
}