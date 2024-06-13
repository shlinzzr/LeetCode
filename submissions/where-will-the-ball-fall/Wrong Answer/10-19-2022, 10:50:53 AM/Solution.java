// https://leetcode.com/problems/where-will-the-ball-fall

class Solution {
    public int[] findBall(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        int[] curr = new int[w];
        for(int i=0;i<w; i++){
            curr[i]=i;
        }
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(j==0 && grid[i][j]==-1)
                    curr[j]=-1;
                
                else if(j+1<w && grid[i][j]==1 && grid[i][j+1]==-1){
                    curr[j]=-1;
                    curr[j+1]=-1;
                    
                }else if(j==w-1 && grid[i][j]==1){
                    curr[j]=-1;
                }
                
                
                if(curr[j]!=-1){
                    if(grid[i][j]==1 && j+1<w){
                        curr[j+1] = curr[j];
                        
                    }else if(grid[i][j]==-1 && j-1>=0 ){
                        curr[j-1] = curr[j];
                        curr[j]=-1;
                    }
                }
            }
        }
        
        int[] res = new int[w];
        Arrays.fill(res, -1);
        for(int i=0; i<w; i++){
            
            if(curr[i]!=-1)
                res[curr[i]]=i;
        }
        
        return res;
            
        
        
    }
}