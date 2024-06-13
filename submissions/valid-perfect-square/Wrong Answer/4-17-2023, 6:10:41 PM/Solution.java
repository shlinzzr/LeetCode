// https://leetcode.com/problems/valid-perfect-square

class Solution {
    public boolean isPerfectSquare(int num) {
        
        
        for(int i=0; i<16; i++){
            
            if(i*i==num)
                return true;
        }
        
        return false;
        
    }
}