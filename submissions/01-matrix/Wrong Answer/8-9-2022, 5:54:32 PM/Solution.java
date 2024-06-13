// https://leetcode.com/problems/01-matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int h = mat.length;
        int w = mat[0].length;
        int max = h * w;
        
        int[][] res = new int[h][w];
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]==0){
                    res[i][j]=0;
                }else{
                    int upCell = (i>0)? res[i-1][j]+1 : max;
                    int leftCell = (j>0)? res[i][j-1]+1 : max;
                    res[i][j] = Math.min(upCell, leftCell) +1;
                }
            }
        }
        
        for(int i=h-1; i>=0; i--){
            for(int j=w-1; j>=0; j--){
                
                if(mat[i][j]==0){
                    res[i][j]=0;
                }else{
                    int downCell =(i<h-1)? res[i+1][j] : max;
                    int rightCell = (j<w-1)? res[i][j+1] : max;
                    res[i][j] = Math.min(res[i][j] , Math.min(downCell, rightCell)+1);
                    
                }
            }
        }
        
        return res;
        
    }
}