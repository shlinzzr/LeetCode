// https://leetcode.com/problems/shortest-path-to-get-food

class Solution {
    public int getFood(char[][] grid) {
        int h= grid.length;
        int w = grid[0].length;
        
        boolean[][] bool = new boolean[h][w];
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<h;i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]=='*')
                    q.offer(new int[]{i, j});
            }
        }
        
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0},{0,-1}};
        
        int step=1;
        while(!q.isEmpty()){
            
            for(int i=q.size(); i>0; i--){
                
                int[] p = q.poll();
                
                for(int[] d : dirs){
                    
                    int r = d[0]+p[0];
                    int c = d[1]+p[1];
                    
                    if(r<0 || c<0 || r>=h || c>=w || bool[r][c] || grid[r][c]=='X') 
                        continue;
                    
                    if(grid[r][c]=='#')
                        return step;
                    
                    bool[r][c] = true;
                    q.offer(new int[]{r,c});
                }
            }
            step++;
        }
        return -1;
    
    }
}