// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {

        int len = s.length();
        int max = 0 ;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int left= 0 ;
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);

            if(ch=='(') 
                st.push(i);
            else{
                st.pop();
                if(st.isEmpty())
                    st.push(i);
                    
                else 
                    max= Math.max(max, i-st.peek());


            }

            
        }
        return max;
        
    }
}