// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        if(s.length()==0)
            return 0;
        
        s = s.trim();
        
        int idx=0, sign=1;
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            sign = s.charAt(0)=='-'? -1 : 1;
            idx++;
        }

        int total=0;
        
        for(int i=idx; i<s.length(); i++){
            char c = s.charAt(i);
            int digit= c-'0';    
            if(digit>9 || digit<0)
                break;
            
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            
            total = 10*total + digit;
        }
        
        
        return sign*total;
        
        
        
        
    }
}