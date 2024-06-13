// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {
        int res=0, sign=1;
        
        Stack<Integer> st =new Stack<>();
            
        for(int i=0; i<s.length(); i++){
            
            if(isNum(s.charAt(i))){
                int num = s.charAt(i)-'0';
                while(i+1<s.length() && isNum(s.charAt(i+1))){
                    num = num*10+ (s.charAt(i+1)-'0');
                    i++;
                }
                res += num*sign;
                
          
                
            }else if('+'==s.charAt(i)){
                sign =1;
                
            }else if('-'==s.charAt(i)){
                sign =-1;
                
            }else if('('==s.charAt(i)){
                
                st.push(res);
                st.push(sign);
                res=0;
                sign=1;
                
            }else if(')'==s.charAt(i)){
                
                res = res*st.pop() + st.pop();
                
            }
            
            
        }
        
        return res;
    
    
    }
    
    public boolean isNum(char c){
        int a = c - '0';
        
        if(a >= 0 && a <= 9){
            return true;
        }
        return false;
    }
    
    
    
}