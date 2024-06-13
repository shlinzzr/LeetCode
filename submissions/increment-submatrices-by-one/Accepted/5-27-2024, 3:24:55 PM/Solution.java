// https://leetcode.com/problems/increment-submatrices-by-one

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {

        // 2d 差分數組
        int[][] diff = new int[n+1][n+1];

        for(int[] q : queries){

            int row1 = q[0];
            int col1 = q[1];
            int row2 = q[2];
            int col2 = q[3];


            diff[row1][col1]++;
            diff[row1][col2+1]--;
            diff[row2+1][col1]--;
            diff[row2+1][col2+1]++;
        }

        int[][] res = new int[n][n];

        for(int i=0; i<n; i++){
            res[i][0] = i==0 ? diff[0][0] : diff[i][0] + res[i-1][0];
            int j = i;
            res[0][j] = j==0 ? diff[0][0] : diff[0][j] + res[0][j-1];
        }



        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){

                res[i][j] = diff[i][j] + res[i-1][j] + res[i][j-1] - res[i-1][j-1];
            }
        }
        return res;





        // brute - force
/*        int[][] res = new int[n][n];
        
        for(int q[] : queries){
            
            for(int i=q[0]; i<=q[2];i++){
                for(int j=q[1]; j<=q[3]; j++){
                    res[i][j]+=1;
                }
            }
        }
        
        return res;*/
    }
}