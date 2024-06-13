// https://leetcode.com/problems/basic-calculator-ii

class Solution {
    public int calculate(String s) {
        
        s = s.trim();
        
        int len = s.length();
        Stack<Integer> st = new Stack<>();
        char op = '+';
        int n = 0;
        
        for(int i=0; i<len; i++){
            
            char ch = s.charAt(i);
            
            if(ch==' ')
                continue;
            
            if(Character.isDigit(ch)){
                n = n*10 + (ch-'0');
            }
            
            if(!Character.isDigit(ch) && ch!=' ' || i==len-1){
                
                if(op=='+')
                    st.push(n);
                
                else if(op=='-')
                    st.push(-n);
                
                else if(op=='*'){
                    st.push(st.pop()*n);    
                    
                }else if(op=='/'){
                    st.push(st.pop()/n);    
                }
                
                n=0;
                op=ch;
            }
        }
        
        
        int total = 0;
        for(int i: st){
            total+=i;
        }
        
        return total;
            
       
    }
}