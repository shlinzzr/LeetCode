// https://leetcode.com/problems/power-of-four

class Solution {
    public boolean isPowerOfFour(int n) {
        
        if(n%4!=0 && n!=1)
            return false;
        
        while(n>0){
            
            if(n==1)
                return true;
            
            n=n/4;
        }
        
        return false;
        
    }
}