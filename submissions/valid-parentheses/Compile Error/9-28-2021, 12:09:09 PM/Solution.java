// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        Stack st  = new Stack();
        
        for(char c : s ){
            if('('.equals(c) ||  '['.equals(c) || '{'.equals(c))
                st.push(c);
            else{
                
                
                
                Char r = st.pop();
                if( '('.equals(r) && !')'.equals(c)
                 || '['.equals(r) && !']'.equals(c)
                 || '{'.equals(r) && !'}'.equals(c))
                    retrun false;
                
                
                
            }
        }
        
        retrun true;
    }
}