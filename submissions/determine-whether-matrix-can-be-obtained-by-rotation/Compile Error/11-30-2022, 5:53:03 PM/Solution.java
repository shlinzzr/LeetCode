// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        boolean[] c = new boolean[4];
        
        Arrays.fill(c, true);
        int h = mat.length;
        int w = mat[0].length;
        int n = h;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]!=target[j][w-i-1]) bool[0] =false;
                if(mat[i][j]!=target[h-i-1][w-j-1]) bool[1]=false;
                if(mat[i][j]!=target[h-j-1][i]) bool[2] = false;
                if(mat[i][j]!=target[i][j]) bool[3]=false;
                
			// if(mat[i][j]!=target[i][j]) c[0]=false;
			// if(mat[i][j]!=target[n-j-1][i]) c[1]=false;
			// if(mat[i][j]!=target[n-i-1][n-j-1]) c[2]=false;
			// if(mat[i][j]!=target[j][n-i-1]) c[3]=false;
                
                
            }
            
        }
        
        return c[0] || c[1] || c[2] || c[3];
        
        
        
    }
    
    
        
}