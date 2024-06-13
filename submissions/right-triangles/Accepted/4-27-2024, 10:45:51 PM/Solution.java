// https://leetcode.com/problems/right-triangles

class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        
        
        int h= grid.length;
        int w= grid[0].length;
        
        int[] cols =  new int[w];
        int[] rows = new int[h];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==1){
                    
                    rows[i]++;
                    cols[j]++;
                    
                }
                
            }
        }
        
        
        long res = 0L;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(rows[i]<2 || cols[j]<2 || grid[i][j]==0) continue;
                
                long a = (long)rows[i]-1;
                
                long b = (long)cols[j]-1; 
                res += a*b;
                // (n-1)+(n-2)+... + 1
                    
                // n * (n-1)/2;
                
            }
        }
        
        
        return res;
        
        
        
    }
    
//     private long cal(long cnt){
        
//         return  n*(n-1)/2;
//     }
}