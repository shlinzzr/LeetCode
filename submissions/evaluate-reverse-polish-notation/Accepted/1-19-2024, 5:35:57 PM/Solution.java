// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        
        for(String s : tokens){
            
            if(set.contains(s)){
                
                int b = st.pop();
                int a = st.pop();
                
                if(s.equals("+")){
                    st.push(a+b);
                    
                }else if(s.equals("-")){
                    st.push(a-b);
                    
                }else if(s.equals("*")){
                    st.push(a*b);
                    
                }else if(s.equals("/")){
                    st.push(a/b);
                }
                
            }else{
                st.push(Integer.valueOf(s));
            }
            
        }
        
        return st.pop();
        
    }
}