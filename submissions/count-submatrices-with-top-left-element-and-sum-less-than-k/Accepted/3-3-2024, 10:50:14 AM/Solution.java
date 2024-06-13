// https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int h = grid.length;
        int w = grid[0].length;
        
        int cnt= 0 ;
        
        for(int i=0; i<h; i++){
            
            for(int j=0; j<w; j++){
                
                
                if(i==0 && j==0){
                      if(grid[i][j]<=k) cnt++;
                    continue;
                        
                } 
                    
                else if(i==0) grid[i][j] += grid[i][j-1];
                else if(j==0) grid[i][j] += grid[i-1][j];
                else 
                    grid[i][j] += grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1];
                
                if(grid[i][j]<=k) {
                    // System.out.println(i+ " "+ j);
                    cnt++;
                }
                
                
                // System.out.print(grid[i][j]+ " ,");
            }
             // System.out.println();
        }
        
        
        
        
        
        return cnt;
        
    }
}