// https://leetcode.com/problems/count-total-number-of-colored-cells

class Solution {
    public long coloredCells(int n) {
        // (2n-1)^2 - 4*(1+....+n-1)
            
            
        // = 4n^2-4n+1 -  (2n^2 +2n)
            
        if(n==1)
            return 1;
        
        return 2*n*n-2*n+1;
    }
}