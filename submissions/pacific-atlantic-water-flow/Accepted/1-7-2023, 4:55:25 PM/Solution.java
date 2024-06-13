// https://leetcode.com/problems/pacific-atlantic-water-flow

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        int h = heights.length;
        int w = heights[0].length;
        
        Boolean[][] pacBool = new Boolean[h][w];
        Boolean[][] atlBool = new Boolean[h][w];
        
        for(int i=0; i<h; i++){
            if(i==0 )
                pacBool[i][0]=true;

            if(i==h-1)
                atlBool[i][w-1]=true;
            
            dfs(heights, pacBool, new int[]{i, 0});
            dfs(heights, atlBool, new int[]{i, w-1});
        }
        
                
        
        for(int j=0; j<w; j++){
            if(j==0)
                pacBool[0][j]=true;

            if(j==w-1)
                atlBool[h-1][j]=true;
            
            dfs(heights, pacBool, new int[]{0, j});
            dfs(heights, atlBool, new int[]{h-1, j});
        }
        
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(pacBool[i][j]!=null && atlBool[i][j]!=null && pacBool[i][j] && atlBool[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
                
            }
        }
        
           
        
        
        return res;        
    }
    
    
    private void dfs(int[][] heights, Boolean[][] pacBool, int[] p){
        
        int h = heights.length;
        int w = heights[0].length;
        int y = p[0];
        int x = p[1];
        
        pacBool[y][x] = true;
        
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        for(int[] d : dirs){
            int r = y+d[0];
            int c = x+d[1];
           
            if(r<0 || r>=h || c<0 || c>=w || (pacBool[r][c]!=null &&  pacBool[r][c]==true))
                continue ;
            
            if( heights[r][c]>=heights[y][x])
                dfs(heights, pacBool, new int[]{r,c});
        }
        
       
    }
    
    
    
    
}