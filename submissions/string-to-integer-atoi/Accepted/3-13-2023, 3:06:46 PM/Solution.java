// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty())
            return 0;
        
        boolean sign = false;
        int idx=0;
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            idx++;
            if(s.charAt(0)=='-')
                sign=true;
        }
        
        int total = 0;
        for(int i=idx; i<s.length(); i++){
            
            int digit = s.charAt(i)-'0';
            if(digit<0 || digit>9){
                break;
            }
            
            
            int num = s.charAt(i)-'0';
            if(total>Integer.MAX_VALUE/10 || (total==Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10)){
                 return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            total = total*10 + digit;
        }
            
       return sign ? -total : total;
        
        
    }
}