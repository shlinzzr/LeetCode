// https://leetcode.com/problems/bomb-enemy

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        
        int max =0 ;
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]=='0'){
                    int[] p =  new int[]{i, j};
                    
                    int cnt =0;
                    
                    for(int st=i; st<h; st++){
                        
                        if(grid[st][j]=='E')    
                            cnt++;
                        if(grid[st][j]=='W')    
                            break;
                    }
                    
                    for(int st=i; st>=0; st--){
                        if(grid[st][j]=='E')    
                            cnt++;
                        if(grid[st][j]=='W')    
                            break;
                    }
                    
                    for(int st=j; st<w; st++){
                        if(grid[i][st]=='E')    
                            cnt++;
                        if(grid[i][st]=='W')    
                            break;
                    }
                    
                    for(int st=j; st>=0; st--){
                        if(grid[i][st]=='E')    
                            cnt++;
                        if(grid[i][st]=='W')    
                            break;
                    }
                    
                    max = Math.max(max, cnt);
                }
            }
        }
        
        return max;
        
    }
}