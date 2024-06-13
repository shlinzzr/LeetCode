// https://leetcode.com/problems/decode-ways

class Solution {
    public int numDecodings(String s) {
        int len = s.length();

        if("0".equals(s)) return 0;

        int res= 0 ;
        if(len==0) return 1;

        if(len==1) return 1;
        
        char ch = s.charAt(0);

        if(ch=='0') return 0;
        else if(ch=='1'){
            if(len>=2) res = numDecodings(s.substring(1)) + numDecodings(s.substring(2));
            else res= numDecodings(s.substring(1));
        }else if(ch=='2'){
            if(len>=2 && s.charAt(1)<='6')  
                res= numDecodings(s.substring(1)) + numDecodings(s.substring(2));
            else res= numDecodings(s.substring(1));
        }

        return res;
        
    }
}