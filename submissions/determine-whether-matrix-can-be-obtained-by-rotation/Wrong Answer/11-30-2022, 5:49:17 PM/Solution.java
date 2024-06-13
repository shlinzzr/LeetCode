// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        boolean[] bool = new boolean[4];
        
        Arrays.fill(bool, true);
        int h = mat.length;
        int w = mat[0].length;
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(mat[i][j]!=target[i][w-j-1]) bool[0] =false;
                if(mat[i][j]!=target[h-i-1][w-j-1]) bool[1]=false;
                if(mat[i][j]!=target[h-i-1][j]) bool[2] = false;
                if(mat[i][j]!=target[i][j]) bool[3]=false;
                
                
            }
            
        }
        
        return bool[0] || bool[1] || bool[2] || bool[3];
        
        
        
    }
    
    
        
}