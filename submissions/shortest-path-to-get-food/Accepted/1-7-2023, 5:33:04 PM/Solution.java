// https://leetcode.com/problems/shortest-path-to-get-food

class Solution {
    public int getFood(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] seen = new boolean[h][w];
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]=='*'){
                    q.add(new int[] {i, j});
                    seen[i][j]=true;
                }
                
            }
        }
        
        int step=1;
        
        int[][] dirs = new int[][]{{0,1} ,{0,-1}, {1,0}, {-1,0}};
        while(!q.isEmpty()){
            
            for(int s=q.size(); s>0; s--){
                int[] p = q.poll();
            
                for(int[] d : dirs){

                    int r = p[0]+d[0];
                    int c = p[1]+d[1];

                    if(r>=0 && r<h && c>=0 && c<w && seen[r][c]==false){
                        
                        seen[r][c]=true;
                        if(grid[r][c]=='#'){
                            return step;
                        }else if(grid[r][c]=='O'){
                            q.add(new int[]{r,c});
                        }
                    }
                }
            }
            step++;
        }
        
        return -1;
        
    }
    
    
}