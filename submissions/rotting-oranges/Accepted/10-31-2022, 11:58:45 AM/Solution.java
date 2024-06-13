// https://leetcode.com/problems/rotting-oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==2)
                    q.offer(new int[]{i, j});
            }
        }
            
        
        int[][] dirs = new int[][]{{1,0} ,{0,1}, {-1,0}, {0,-1}};
        
        int cnt=0;
        while(!q.isEmpty()){
            int siz = q.size();
            
            
            boolean gotRotten = false;
            for(int i=0; i<siz; i++){
                
                int[] axis = q.poll();
                
                for(int[] d : dirs){
                    int r = axis[0]+d[0];
                    int c = axis[1]+d[1];                    
                    
                    if(r>=0 && r<h && c>=0 && c<w && grid[r][c]==1){
                        q.add(new int[]{r,c});
                        grid[r][c]=2;
                        gotRotten=true;
                    }
                }
            }
            if(gotRotten)
                cnt++;
        }
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==1)
                    return -1;
            }
        }
        
    
        
        return cnt;
    }
}