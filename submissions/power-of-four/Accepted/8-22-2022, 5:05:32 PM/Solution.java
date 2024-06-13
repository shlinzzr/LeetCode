// https://leetcode.com/problems/power-of-four

class Solution {
    public boolean isPowerOfFour(int n) {
        
        while(n>0){
            
            if(n==1)
                return true;
            
            if(n%4!=0)
                return false;
            
            n=n/4;
        }
        
        return false;
        
    }
}