// https://leetcode.com/problems/bitwise-and-of-numbers-range

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
         // 5 = 0101, 7=0111 and = 0101=5
        
        if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
        
    }
}