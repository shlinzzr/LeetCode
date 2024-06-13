// https://leetcode.com/problems/basic-calculator-ii

class Solution {
    public int calculate(String s) {
        int res=0, sum=0;
        
        Stack<Integer> st = new Stack<>();
        char sign = '+';
        for(int i=0; i<s.length(); i++){
            
            
            
            char ch = s.charAt(i);  
            
            if(ch==' ')
                continue;
            
            if(Character.isDigit(ch)){
                sum=sum*10+(ch-'0');
                
            } 
            
            if(!Character.isDigit(ch)  || i==s.length()-1){
           
                if(sign=='+'){
                    st.push(sum);

                }
                if(sign=='-'){
                    st.push(-sum);

                }
                if(sign=='*'){
                    st.push(st.pop()*sum);

                }
                if(sign=='/'){
                    st.push(st.pop()/sum);
                }
                
                sign = ch;
                sum=0;
            }
        }
        
        int total=0;
         for(int n : st){
             System.out.println(n);
            total+=n;
        }
        
        return total;
    }
}