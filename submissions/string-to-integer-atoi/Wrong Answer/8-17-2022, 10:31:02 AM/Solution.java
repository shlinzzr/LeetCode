// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
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
            
            
            
            
            total = 10*total + digit;
        }
        
        
        return sign*total;
        
        
        
        
    }
}