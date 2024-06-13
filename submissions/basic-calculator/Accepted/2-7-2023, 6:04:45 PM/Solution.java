// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {
        int res = 0;
        
        int len = s.length();
        int sign=1;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<len; i++){
            
            char ch = s.charAt(i);
            
            if(ch==' '){
                continue;
                
            }else if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }
                
                res+=num*sign;
                
            }else if(ch=='+'){
                sign=1;
                
            }else if(ch=='-'){
                sign=-1;
                
            }else if(ch=='('){
                st.push(res);
                st.push(sign);
                res=0;
                sign=1;
                
            }else if(ch==')'){
                res=res*st.pop() + st.pop();
            }
        }
        
        return res;
        
    }
}