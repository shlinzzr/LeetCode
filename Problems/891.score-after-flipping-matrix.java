// https://leetcode.com/problems/score-after-flipping-matrix

class Solution {
    public int matrixScore(int[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;
        
        for(int j=0; j<w;j++){
            
            int zcnt =0;
            for(int i=0; i<h; i++){
                if(j==0 && grid[i][j]==0){
                    reverseRow(grid, i);
                    
                }else if(grid[i][j]==0){
                    zcnt++;
                }
            }
            
            if(zcnt>h/2){
                reverseCol(grid, j);
            }
            
        }
        
//          for(int i=0; i<h; i++){
             
//              for(int j=0; j<w; j++){
//                  System.out.print(grid[i][j]);
//              }
//              System.out.println();
//          }
        
        
        int res = 0; 
        for(int i=0; i<h; i++){
            int sum = 0;
            int mul = 1;
            for(int j=w-1; j>=0; j--){
                sum+= mul*grid[i][j];
                mul*=2;
            }
            res += sum;
        }
        return res;
        
    }
    
    
    private void reverseRow (int[][] grid, int i){
        // System.out.println("reverseRow:" + i);
        
        for(int j=0; j<grid[0].length;j++){
            grid[i][j] ^= 1;
        }
    }
    
    private void reverseCol (int[][] grid, int j){
        // System.out.println("reverseCol:" +j);
        for(int i=0; i<grid.length;i++){
            grid[i][j] ^= 1;
        }
    }
    
}