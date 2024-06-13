// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length()==0)
            return 0;
        
        int idx =0;
        boolean sign=false;
        if(s.charAt(0)=='+' || s.charAt(0)=='-'){
            idx=1;
            if(s.charAt(0)=='-')
                sign=true;
        }
        
        int sum=0;
        for(int i=idx; i<s.length(); i++){
            
            int digit = s.charAt(i)-'0';
            if(digit<0 || digit>9)
                break;
            
            if(sum==Integer.MAX_VALUE/10 && digit>= Integer.MAX_VALUE%10 || sum > Integer.MAX_VALUE/10){
                return sign? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            sum = sum*10 + digit;
        }
        
        return sum;
    }
}