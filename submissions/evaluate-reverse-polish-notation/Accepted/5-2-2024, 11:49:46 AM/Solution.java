// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {


        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<tokens.length; i++){

            String t = tokens[i];
            
            if(set.contains(t)){
                int b = st.pop();
                int a = st.pop();
                if("+".equals(t)){
                    st.push(a+b);

                }else if("-".equals(t)){
                    st.push(a-b);

                }else if("*".equals(t)){
                    st.push(a*b);

                }else if("/".equals(t)){
                    st.push(a/b);
                }

            }else{
                st.push(Integer.parseInt(t));
            }
        }

        int sum = 0;
        for(int a : st){
            sum += a;
        }


        return sum;
        
    }
}