// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
        int cnt=0;
        
        
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        
        int cur =0;
        for(int i=0; i<arr.length; i++){
            
            char c = arr[i];
            
            if(c=='(')
                st.push('(');
            
            else if(c==')'){
                if(st.isEmpty()){
                    cur=0;
                }else{
                    st.pop();
                    cur++;
                    cnt = Math.max(cur, cnt);
                    System.out.println(cnt);
                }
            }
            
            
            
        }
        
        return 2*cnt;
    }
}