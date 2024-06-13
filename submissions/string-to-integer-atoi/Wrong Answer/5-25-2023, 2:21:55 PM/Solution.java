// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        
        boolean sign = false;
        int idx = 0;
        if(s.charAt(0)=='+' || s.charAt(1)=='-'){
            idx++;
            if(s.charAt(1)=='-'){
                sign=true;
            }
        }
            
        int sum = 0;
        for(int i=idx; i<len; i++){
            
            int digit = s.charAt(i)-'0';
            if(digit<0 || digit>9)
                return -1;
            
            if(sum>Integer.MAX_VALUE/10 || (sum==Integer.MAX_VALUE/10 && digit>=Integer.MAX_VALUE%10)){
                return sign? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            sum = sum *10 + digit;
        }
        
        return sum;
        
        
    }
}