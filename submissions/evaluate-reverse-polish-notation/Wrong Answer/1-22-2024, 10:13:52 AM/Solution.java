// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        
        int len = tokens.length;
        
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        Stack<Integer> st = new Stack();
        
        for(String t : tokens){
            
            if(set.contains(t)){
                
                if("+".equals(t)){
                    st.push(st.pop()+st.pop());
                }else if("-".equals(t)){
                    st.push(st.pop()-st.pop());
                }else if("*".equals(t)){
                    st.push(st.pop()*st.pop());
                }else if("/".equals(t)){
                    st.push(st.pop()/st.pop());
                }
            }else{
                st.push(Integer.valueOf(t));
            }
        }
        
        int res = 0;
        while(!st.isEmpty()){
            res+=st.pop();
        }
        
        
        return res;
    }
}