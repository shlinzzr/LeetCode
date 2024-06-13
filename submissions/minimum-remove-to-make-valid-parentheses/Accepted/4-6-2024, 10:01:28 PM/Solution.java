// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses

class Solution {
    public String minRemoveToMakeValid(String s) {
        int cnt=0;
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch==')'){
                
                if(st.isEmpty())
                    cnt++;
                else {
                    st.pop();
                    sb.append(ch);
                }
                
                
            }else if (ch=='('){
                
                st.push(sb.length());
                sb.append(ch);
            }else{
                sb.append(ch);
            }
            
            
        }
        
        
        int size = st.size();
        for(int i=0; i<size; i++){
            sb.deleteCharAt(st.pop());
        }
        
        return sb.toString();
    }
}