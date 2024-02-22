// https://leetcode.com/problems/neighboring-bitwise-xor

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int ans = 0;
        
        for(int d : derived){
            ans = ans ^ d;
        }
        
        
        return ans==0;
        
        // org [0,1,0].
         // // derived = [1,  1,  0] === 0
         //             0^2 ^ 0^1 ^ 1^2
                         
        
        
        
        
    }
}