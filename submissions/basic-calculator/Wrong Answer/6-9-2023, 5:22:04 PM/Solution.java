// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {
        s = s.trim();
        
        Stack<Integer> st = new Stack<>();
        int len = s.length();
        
        int n = 0;
        int sign = 1;
        
        
        
        for(int i=0; i<len; i++){
            
            char ch = s.charAt(i);
            
            if(ch==' ')
                continue;
            
            if(Character.isDigit(ch)){
                n = n *10 + (ch-'0');
            }
            
            if(!Character.isDigit(ch) && ch!=' ' || i==s.length()-1){
                
                if(ch=='('){
                    
                    st.push(n);
                    st.push(sign);
                    n=0;
                    sign=1;
                    
                }else if(ch=='+')
                    sign=1;
                else if(ch=='-')
                    sign=-1;
                
                else if(ch==')'){
                    
                    n = n*st.pop() + st.pop();    
                }
            }
        }
        
        return n;
        
    }
}