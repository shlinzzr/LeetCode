// https://leetcode.com/problems/minimum-operations-to-write-the-letter-y-on-a-grid

class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        
        int h = grid.length;
        int w = grid[0].length;
        
        int[] arr = new int[3];
        int cnt= 0;
        
        int[] not_y = new int[3];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                int anti_j = w-i-1;
                if(i<h/2 && (i==j || j==anti_j)){
                    continue;
                }else if(i>=h/2 && j==w/2){
                    continue;
                }else{
                    
                    not_y[ grid[i][j]]++; 
                }
                
            }
        }
        
        
        
        // 5, i: 0,1,2 3 4
        for(int i=0; i<h/2; i++){
            
            int anti_j = w-i-1;
            
            arr[ grid[i][i] ] ++;
            arr[grid[i][anti_j]] ++;
            cnt+=2;
        }
        
        
        
        for(int i=h/2; i<h; i++){
            int j=w/2;
            arr[ grid[i][j] ]++;
            cnt++;
        }
        
        int z = arr[0];
        int o = arr[1];
        int t = arr[2];
        
//         System.out.println(z+ " "+ o + " "+ t+ " "+cnt);
        
//         System.out.println(not_y[0]+ " "+ not_y[1] + " "+ not_y[2]);
        
        
        int    resz = cnt-z+not_y[0] + Math.min(not_y[1], not_y[2]);
         int   reso = cnt-o + not_y[1]+ Math.min(not_y[0], not_y[2]);;
         int   rest =  cnt-t + not_y[2]+ Math.min(not_y[1], not_y[0]);;
        
        return Math.min(resz, Math.min(reso, rest));
        
    }
}