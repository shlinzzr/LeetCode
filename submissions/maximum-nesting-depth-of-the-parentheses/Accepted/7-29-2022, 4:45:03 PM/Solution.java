// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses

class Solution {
    public int maxDepth(String s) {
        int de = 0;
        
        Stack<Character> st = new Stack<>();
        
        for(char c : s.toCharArray()){
            
            if(c=='('){
                st.push(c);
                de = Math.max(de, st.size());
                    
            }else if(c==')'&&st.size()>0)
                st.pop();
            else{
                // do nothing
            }
            
            
            
        }
        
        return de;
    }
}