// https://leetcode.com/problems/power-of-two

class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if(n==1)
            return true;
        
        while(n>0){
            if(n%2==1)
                return false;
            n>>=1;
        }
        
        return true;
        
    }
}