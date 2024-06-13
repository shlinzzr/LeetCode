// https://leetcode.com/problems/matrix-diagonal-sum

class Solution {
    public int diagonalSum(int[][] mat) {
        int len = mat.length;
        
        int res =0;
        
        for(int i=0; i<len; i++){
            
            res += mat[i][i];
            res += mat[i][len-i-1];
        }
        
        if(len%2==1)
            res-=mat[len/2][len/2];
        
        return res;
        
        
    }
}