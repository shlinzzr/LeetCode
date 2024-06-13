// https://leetcode.com/problems/increment-submatrices-by-one

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        
        for(int q[] : queries){
            
            for(int i=q[0]; i<=q[2];i++){
                for(int j=q[1]; j<=q[3]; j++){
                    res[i][j]+=1;
                }
            }
        }
        
        return res;
    }
}