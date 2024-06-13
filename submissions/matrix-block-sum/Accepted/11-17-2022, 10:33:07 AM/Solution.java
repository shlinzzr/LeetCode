// https://leetcode.com/problems/matrix-block-sum

class Solution {
    int m;
    int n;
    
    public int[][] matrixBlockSum(int[][] mat, int k) {
        m = mat.length;
        n = mat[0].length;
        
        int[][] ans = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                int sum=getSum(mat, i, j, k);
                ans[i][j] = sum;
                
            }
        }
        
        return ans;
    }
    
    
    private int getSum(int[][] mat, int i, int j, int k){
        
        int sum=0;
        for(int r=i-k; r<=i+k; r++){
            for(int c=j-k; c<=j+k; c++){
                
                if(r<0||r>=m || c<0 || c>=n)
                    continue;
                sum += mat[r][c];
            }
        }
        return sum;
        
    }
}