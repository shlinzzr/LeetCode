// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {
        int res = 0;
        
        Stack<Integer> ist = new Stack<>();
        
        int sign=1;
        int num = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch==' ')
                continue;
            
            else if(Character.isDigit(ch)){
                num = ch-'0';
                while(i+1<s.length() &&Character.isDigit(s.charAt(i+1))){
                    num = num*10+ (s.charAt(i+1)-'0');
                    i++;
                }
                res += num*sign;
                
            }else if(ch=='-'){
                sign=-1;
                
            }else if(ch=='+'){
                sign=1;
            }else if(ch == '('){
                
                ist.push(res);
                ist.push(sign);
                res=0;
                sign=1;
            }else if(ch==')'){
                res = res*ist.pop() + ist.pop();
                
                
            }
                
            
            
        }
            
            return res;
    }
}