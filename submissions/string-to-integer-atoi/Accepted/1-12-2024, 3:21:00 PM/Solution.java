// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        
        s = s.trim();
        int idx= 0;
         int len = s.length();
        if(len==0)return 0;
        
        boolean sign = false;
        if(s.charAt(0)=='+' || s.charAt(0)=='-'){
            idx=1;
            
            if(s.charAt(0)=='-')
                sign=true;
        }
       
        int sum = 0 ;
        while(idx<len){
            
            char ch = s.charAt(idx);
            if(ch<'0' ||ch>'9')
                break;
                
                if(sum>Integer.MAX_VALUE/10 || (sum==Integer.MAX_VALUE/10 && (ch-'0')>Integer.MAX_VALUE%10))
                    return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                
                sum=sum*10+ (ch-'0');
            idx++;
            
            
        }
        
        return sign ? -sum : sum;
        
    }
}