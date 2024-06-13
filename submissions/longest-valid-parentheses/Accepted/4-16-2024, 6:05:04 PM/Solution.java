// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {

        int len = s.length();
        int max = 0 ;
        Stack<Integer> st = new Stack<>();
        st.push(-1); // set the pivot with last valid start pos
        int left= 0 ;
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);

            if(ch=='(') 
                st.push(i);
            else{
                st.pop(); // ignore curr valid pos, check the last valid pivot
                if(st.isEmpty())
                    st.push(i); // if st.isEmpty(), update the last valid pivot postion
                else 
                    max= Math.max(max, i-st.peek());
            }
        }
        return max;
    }
}