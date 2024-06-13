// https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero

class Solution {
    public int makeTheIntegerZero(int x, int y) {
        
        /*
        The maximum operations is num, num = (2 ^ 0) * num.
        The minimum operations is num bits count.

        If num.bit_count() <= k <= num, (num 是會變的, num=x-k*y )
        then num can be the sum of k pows of 2.
        */
        
        for (int k = 1; k < 61; k++){
            
            long target = x-(long)k*y;
            
            if (Long.bitCount(target) <= k && k <=target)
                return k;
      
        }
        
        return -1;
    }
    
    
}