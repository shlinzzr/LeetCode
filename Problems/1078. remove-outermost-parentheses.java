// https://leetcode.com/problems/remove-outermost-parentheses

class Solution {
    public String removeOuterParentheses(String s) {
        Stack<String> st = new Stack<>();
        
        int len = s.length();
        
        String cur = "";
        int left = 0;
        for(int i=0; i<len; i++){
            
            char ch = s.charAt(i);
            
            if(st.isEmpty() && ch=='('){
                st.push(cur);
                cur = "";
                
            }else if(!st.isEmpty() && left==0 && ch==')'){
                cur = st.pop() + cur;
                
            }else{
                
                if(ch=='(')
                    left++;
                else 
                    left--;
                
                cur += ch;
            }
            
            // System.out.println(i + " " + cur);
        }
        
        return cur;
    }
}