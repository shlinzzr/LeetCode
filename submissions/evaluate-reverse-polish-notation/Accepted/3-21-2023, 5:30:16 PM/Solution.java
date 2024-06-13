// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<len; i++){
            
            String token = tokens[i];
            
            if(token.equals("+")){
                int b = st.pop();
                int a = st.pop();
                st.push(a+b);
                
            }else if(token.equals("-")){
                int b = st.pop();
                int a = st.pop();
                st.push(a-b);
                
            }else if(token.equals("*")){
                int b = st.pop();
                int a = st.pop();
                st.push(a*b);                
                
                
            }else if(token.equals("/")){
                int b = st.pop();
                int a = st.pop();
                st.push(a/b);
                
                
            }else{
                st.push(Integer.valueOf(token));
            }
        }
        
        int res = 0;
        for(int i : st){
            res+=i;
        }
        
        return res;
        
    }
}