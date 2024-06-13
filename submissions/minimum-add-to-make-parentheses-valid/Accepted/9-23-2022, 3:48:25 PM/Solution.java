// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid

class Solution {
    public int minAddToMakeValid(String s) {
        int cnt=0;
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==')'){
                if(st.isEmpty())
                    cnt++;
                else
                    st.pop();
                
            }else{
                st.push(ch);
            }
        }
        
        cnt += st.size();
        
        return cnt;
    }
}