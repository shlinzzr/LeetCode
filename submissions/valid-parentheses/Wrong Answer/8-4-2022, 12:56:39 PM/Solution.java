// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        Stack<Character> sst = new Stack<>();
        Stack<Character> mst = new Stack<>();
        Stack<Character> lst = new Stack<>();
        
        for(char c : s.toCharArray()){
            
            if( !isValid(c, sst, '(', ')') 
             || !isValid(c, mst, '{', '}')
             || !isValid(c, lst, '[', ']'))
              
                return false;
        }
        
        
        if(!sst.isEmpty() || !mst.isEmpty() || !lst.isEmpty())
            return false;
        
        return true;
    }
    
    private boolean isValid(char c, Stack<Character> st,  char cl, char cr){
        
        if(c==cl)
                st.push(c);
            else if(c==cr) {
                if(st.isEmpty())
                    return false;
                else
                    st.pop();
                
        }
        return true;
    }
    
}