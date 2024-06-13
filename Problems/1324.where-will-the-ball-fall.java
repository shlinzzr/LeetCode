// https://leetcode.com/problems/where-will-the-ball-fall

class Solution {
    public int[] findBall(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        int[] prev = new int[w];
        for(int i=0;i<w; i++){
            prev[i]=i;
        }
        
        for(int i=0; i<h; i++){
            
            int[] curr = new int[w];
            Arrays.fill(curr, -1);
            
            for(int j=0; j<w; j++){
                
                if(j==0 && grid[i][j]==-1)
                    prev[j]=-1;
                
                else if(j+1<w && grid[i][j]==1 && grid[i][j+1]==-1){
                    prev[j]=-1;
                    prev[j+1]=-1;
                    
                }else if(j==w-1 && grid[i][j]==1){
                    prev[j]=-1;
                }
                
                
                if(prev[j]!=-1){
                    if(grid[i][j]==1 ){
                        
                        if(j+1<w){
                            curr[j+1] = prev[j];    
                        }else 
                            curr[j]=-1;
                        
                    }else if(grid[i][j]==-1){
                        
                        if(j-1>=0){
                            curr[j-1] = prev[j];
                        }
                        else
                            curr[j]=-1;
                    }
                }
            }
            prev = curr;
            
        }
   
        
        
        
        int[] res = new int[w];
        Arrays.fill(res, -1);
        for(int i=0; i<w; i++){
            
            if(prev[i]!=-1)
                res[prev[i]]=i;
        }
        
        return res;
            
        
        
    }
}