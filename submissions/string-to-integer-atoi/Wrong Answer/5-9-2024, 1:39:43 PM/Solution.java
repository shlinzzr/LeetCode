// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {

        int res = 0 ;

        s = s.trim();

        int max = Integer.MAX_VALUE;

        int len = s.length();

        if(len==0) return 0;

        if(s.charAt(0)=='-')
            return -myAtoi(s.substring(1));


        for(int i=0; i<len; i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9') break;

            if(res>max/10 || (res==max/10 && (s.charAt(i)-'0')>max%10))
                return max;

            res = res*10 + s.charAt(i)-'0';

            System.out.println(res);
        }

        return res;
        
    }
}