// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {
        int res=0, sign=1;
        
        Stack<Integer> st =new Stack<>();
            
        for(int i=0; i<s.length(); i++){
            
            if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i)-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num*10+num;
                    i++;
                }
                res += num*sign;
                
            }else if('-'==s.charAt(i)){
                sign =-1;
                
            }else if('+'==s.charAt(i)){
                sign =1;
                
            }else if('('==s.charAt(i)){
                
                st.push(res);
                st.push(sign);
                res=0;
                sign=1;
                
            }else if(')'==s.charAt(i)){
                
                res += res*st.pop() + st.pop();
                
            }
            
            
        }
        
        return res;
    }
}