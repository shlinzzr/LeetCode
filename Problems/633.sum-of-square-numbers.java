// https://leetcode.com/problems/sum-of-square-numbers

class Solution {
    public boolean judgeSquareSum(int c) {
        
        
        
        for(int i=0; i<=Math.sqrt(c); i++){
            
            int js = c-i*i;
            
            int j = (int)Math.sqrt(js);
            
            if(j*j==js)
                return true;
            
            
        }
        
        return false;
    }
}