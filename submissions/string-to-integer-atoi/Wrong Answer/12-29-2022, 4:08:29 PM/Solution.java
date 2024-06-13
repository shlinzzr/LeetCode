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

            int cur=0;

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
            
            return cur;
        }
        
        return -1;

    }
}