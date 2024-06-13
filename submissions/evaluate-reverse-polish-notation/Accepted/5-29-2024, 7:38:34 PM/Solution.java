// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {

        int len = tokens.length;

        Stack<Integer> st = new Stack<>();

        for(String t : tokens){

            if(t.length()==1){
                char ch = t.charAt(0);

                if(ch=='+'){
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a+b);
                    continue;

                }else if(ch=='-'){
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a-b);
                     continue;

                }else if(ch=='*'){
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a*b);
                     continue;

                }else if(ch=='/'){
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a/b);
                     continue;
                }   
            }
            st.push(Integer.parseInt(t));
            
            
        }

        int sum = 0;
        for(int v : st){
            sum += v;
        }

        return sum;
        
    }
}