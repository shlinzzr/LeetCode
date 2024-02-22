// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid

class Solution {
    public int minAddToMakeValid(String s) {
        int cnt=0, open=0, close=0;
        
        
        // Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==')'){
                if(open==0)
                    cnt++;
                else
                    // st.pop();
                    open--;
                
            }else{
                open++;
                // st.push(ch);
            }
        }
        
        // cnt += st.size();
        cnt += open;
        
        return cnt;
    }
}