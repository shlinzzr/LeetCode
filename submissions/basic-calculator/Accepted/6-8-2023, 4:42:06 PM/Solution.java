// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {
        
        
        Stack<Integer> st = new Stack<>();
        
        int sign=1;
        int res = 0;
        
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(ch==' ')
                continue;
            
            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }
                res += sign*num;
                
            }else if(ch =='-'){
                sign=-1;
                
            }else if(ch=='+')
                sign=1;
            
            else if(ch=='('){
                st.push(res);
                st.push(sign);
                res=0;
                sign=1;
                
            }else if(ch==')'){
                
                res = res*st.pop() + st.pop();
            }
        }
        
        
        return res;
    }
}