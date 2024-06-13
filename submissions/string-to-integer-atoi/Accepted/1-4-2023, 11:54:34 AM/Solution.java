// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        
        if(s.length()==0)
            return 0;
        
        int idx =0;
        boolean sign = false;
        if(s.charAt(0)=='-'){
            sign=true;
            idx++;
        }
        
        if(s.charAt(0)=='+'){
            idx++;
        }
        
        
        int total=0;
        
        
        for(int i=idx;i<s.length(); i++){
            int digit = s.charAt(i)-'0';
            if(digit<0 || digit>9){
                break;
                // return -1;
            }
            
            if(total>Integer.MAX_VALUE/10 || total==Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10){
                return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            total = total*10 + digit;
        }
        
        return sign ? -total : total;
        
    }
}