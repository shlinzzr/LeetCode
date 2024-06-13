// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {
        s = s.trim();
        
        Stack<Integer> st = new Stack<>();
        int len = s.length();
        
        int curr = 0;
        int res =0; 
        int sign = 1;
        
        
        for(int i=0; i<len; i++){
            
            char ch = s.charAt(i);
            
            if(ch==' ')
                continue;
            
            if(Character.isDigit(ch)){
                curr = curr *10 + (ch-'0');
            }
            
            
                
            else if(ch=='+'){
                    res += curr * sign;
                    curr=0;
                    sign=1;
                    
                }else if(ch=='-'){
                    res += curr * sign;
                    curr=0;
                    sign=-1;
                    
                } else if(ch=='('){
                    st.push(res);
                    st.push(sign);
                    res = 0 ;
                    sign=1;
                    
                    
                }else if(ch==')'){
                    res += curr*sign;
                    res = res*st.pop() + st.pop();    
                   curr = 0;
                }
            }
        
        
         if (curr != 0) res += curr * sign;
        return res;
        
    }
}