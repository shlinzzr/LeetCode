// https://leetcode.com/problems/flip-string-to-monotone-increasing

class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int len = s.length();
        
        int firstOne = s.indexOf("1");
        int firstZero = s.indexOf("0");
        
        
        // if(firstOne>len/2 || firstZero>len/2)
        // {
            int cnt=0, zcnt=0, ocnt=0;
            // if(firstOne>len/2){ // 0's cnt > 1's cnt => find all 1;
                for(int i=firstOne; i<len; i++){
                    if(s.charAt(i)=='1')
                        cnt++;
                    else{
                        zcnt++;
                    }
                }
            // }else{
                for(int i=firstZero; i<len; i++){
                    if(s.charAt(i)=='0')
                        ocnt++;
                }
            // }
            return Math.min(cnt, Math.min(zcnt, ocnt));
        // }
        
        
        
        
    }
}