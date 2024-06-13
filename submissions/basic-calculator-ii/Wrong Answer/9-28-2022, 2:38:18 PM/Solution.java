// https://leetcode.com/problems/basic-calculator-ii

class Solution {
    public int calculate(String s) {
        int len = s.length();
        if(s==null || ( s.length())==0) return 0;
        
        Stack<Integer> st = new Stack<>();
        char sign= '+';
        int res=0, num=0;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            
            if(c!=' ' || i==s.length()-1){
                
                if(sign=='+'){
                    st.push(num);
                    
                }else if(sign=='-'){
                    st.push(-num);
                    
                }else if(sign=='*'){
                    st.push(st.pop()*num);
                    
                    
                }else if(sign=='/'){
                    st.push(st.pop()/num);
                }
                
                sign = s.charAt(i);
                num=0;
            }
        }
        
        
        for(int n : st){
            res +=n;
        }
        
        return res;
    }
}