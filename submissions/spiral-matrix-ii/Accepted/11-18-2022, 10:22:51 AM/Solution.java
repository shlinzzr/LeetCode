// https://leetcode.com/problems/spiral-matrix-ii

class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] res = new int[n][n];
        
        int top = 0;
        int bottom = n-1;
        int left =0;
        int right = n-1;
        
        
        int i=1;
        int j=0;
        while(true){
            
            for( j=left; j<=right; j++){  res[top][j] = i++;}
            top++;
            if(left>right || top>bottom) break;
            
            
            for( j=top; j<=bottom; j++){ res[j][right]=i++; }
            right--;
            if(left>right || top>bottom) break;
            
            for( j=right; j>=left; j--){ res[bottom][j]=i++; }
            bottom--;
            if(left>right || top>bottom) break;
            
            for( j=bottom; j>=top; j--) { res[j][left]=i++; }
            left++;
            if(left>right || top>bottom) break;
        }
        
        return res;
        
        
    }
}