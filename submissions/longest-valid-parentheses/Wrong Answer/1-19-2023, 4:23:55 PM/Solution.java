// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
        int cnt=0;
        
        Stack<Character> st = new Stack<>();
        
        int max=0;
        for(char ch : s.toCharArray()){
            
            if(ch=='('){
                st.push(ch);
            }else{ //ch==)
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                    cnt+=2;
                    max = Math.max(max, cnt);
                }else{
                    cnt=0;
                }
                
            }
        }
        return max;
    }
}