// https://leetcode.com/problems/arranging-coins

class Solution {
    public int arrangeCoins(int n) {
        
        int row=1;
        
        while(n>=row){
            
            n-=row;
            row++;
        }
        
        return n==0 ? row : row-1;
        
    }
}