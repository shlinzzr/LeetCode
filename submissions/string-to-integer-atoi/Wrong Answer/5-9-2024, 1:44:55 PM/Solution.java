// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {

        int res = 0 ;

        s = s.trim();

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        int len = s.length();

        if(len==0) return 0;

        

        int i = 0;
        boolean sign = false;
        if(s.charAt(0)=='-'){
            i=1;
            sign = true;
        }

        for(; i<len; i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9') break;

            if(res>max/10 || (res==max/10 && (s.charAt(i)-'0')>max%10))
                return sign ? min : max;

            res = res*10 + s.charAt(i)-'0';
        }

        return sign ? -res : res;
        
    }
}