// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {
        int num=0;
        char sign='+';
        int total=0;
        
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }
            
            if(!Character.isDigit(c) && c!=' ' || i==s.length()-1){
                
                if(sign=='+'){
                    st.push(num);
                }
                if(sign=='-'){
                    st.push(-num);
                }
                if(sign=='*'){
                    st.push(st.pop()*num);
                }
                if(sign=='/'){
                    st.push(st.pop()/num);
                }
                
                sign = c;
                num=0;
            }
        }
        
        for(int n : st){
            total+=n;
        }
        
        return total;
        
        
    }
}