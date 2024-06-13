// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        
        
        String[] arr = s.split(" ");
        
        for(String str : arr){
            boolean isNeg = s.charAt(0)=='-';
        
            int len = s.length();
            int idx =0;
            if(isNeg){
                idx=1;
            }

            long cur=0;

            while(idx<len){

                char c = s.charAt(idx);
                if(c<'0' || c>'9')
                    break;


                int n = c-'0';

                cur = cur*10 + n; 
                idx++;
            }

            if(isNeg)
                cur = -cur;
            
             if(Integer.MAX_VALUE/10 < cur || Integer.MAX_VALUE/10 == cur && Integer.MAX_VALUE %10 < cur)
            return cur == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            return (int)cur;
        }
        
        return -1;

    }
}