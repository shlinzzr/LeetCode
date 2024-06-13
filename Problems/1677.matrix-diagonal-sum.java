// https://leetcode.com/problems/matrix-diagonal-sum

class Solution {
    public int diagonalSum(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;
        
        
        boolean del = false;
        if(h%2==1)
            del=true;
        
        int sum=0;
        
        for(int i=0; i<h;i++){
            sum+=mat[i][i];
            sum+=mat[i][h-i-1];
        }
        
        if(del)
            sum-=mat[h/2][h/2];
        
        return sum;
        
        
    }
}