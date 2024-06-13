// https://leetcode.com/problems/flip-string-to-monotone-increasing

class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int len = s.length();
        int zcnt=0, ocnt=0;
        for(char ch : s.toCharArray()){
            if(ch=='0')
                zcnt++;
        }
        
        int res = zcnt;
        
        for(char ch : s.toCharArray()){
            
            if(ch=='0'){
                zcnt-=1;
                    
            }else{ // '1'
                res = Math.min(res, zcnt+ocnt);
                ocnt+=1;
            }
        }
        
        return res;
        
        
        
    }
}