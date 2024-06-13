// https://leetcode.com/problems/flip-string-to-monotone-increasing

class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int len = s.length();
        
        int firstOne = s.indexOf("1");
        int firstZero = s.indexOf("0");
        
        
            int cnt=0, zcnt=0, ocnt=0;
            
            if(firstOne==-1)
                return 0;
        
            else{ // 0's cnt > 1's cnt => flip 1;
                for(int i=firstOne; i<len; i++){
                    if(s.charAt(i)=='1')
                        cnt++;
                    else{
                        zcnt++;
                    }
                }
                
                for(int i=len-1; i>=0; i--){
                     if(s.charAt(i)=='1'){
                         cnt--;
                     }else
                         break;
                }
                
            }
        
            if(firstZero==-1){
                return 0;
                
            }else{
                for(int i=firstZero; i<len; i++){
                    if(s.charAt(i)=='0')
                        ocnt++;
                }
            }
            return Math.min(cnt, Math.min(zcnt, ocnt));
        
        
        
        
    }
}