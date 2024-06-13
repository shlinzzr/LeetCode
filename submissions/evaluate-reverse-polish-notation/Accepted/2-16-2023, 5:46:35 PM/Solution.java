// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> st = new Stack<>();
        
        for(String t : tokens){
            
            if(t.equals("+")){
                st.push(st.pop()+st.pop());
            
            }else if(t.equals("-")){
                st.push(-st.pop()+st.pop());
            
            }else if(t.equals("*")){
                st.push(st.pop()*st.pop());

            }else if(t.equals("/")){
                int b = st.pop();
                int a = st.pop();
                st.push(a/b);
            }else{
                st.push(Integer.valueOf(t));
            }
        }
        
        int res =0;
        for(int a : st){
            res+=a;
        }
        
        return res;
        
    }
}