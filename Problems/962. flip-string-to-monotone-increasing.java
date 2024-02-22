// https://leetcode.com/problems/flip-string-to-monotone-increasing

class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int len = s.length();
        //https://www.youtube.com/watch?v=FhnLePtVrY4&t=256s
        
        int flip=0, ones=0;
        
        
        for(char ch : s.toCharArray()){
            if(ch=='0'){
                if(ones!=0)
                    flip++; //前面有1的情況下後面的0才需要flip
                else 
                    continue;
                
            }else {
               ones++;
            }
            
            if(flip>ones)
                flip=ones;
            
        }
        
        return flip;
        
        
        
    }
}