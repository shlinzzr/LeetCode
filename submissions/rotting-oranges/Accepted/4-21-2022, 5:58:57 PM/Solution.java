// https://leetcode.com/problems/rotting-oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();
        
        int h = grid.length;
        int w = grid[0].length;
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[i][j]==2)
                    queue.offer(new int[]{j,i});
            }
        }
        
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        
        int last = -1;
        int c=0;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            boolean hasRotten = false;
            for(int[] d : dirs){
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];
                
                if(x<0 || x>=w || y<0 || y>=h || grid[y][x]!=1)
                    continue;
                queue.offer(new int[]{x,y});
                
                grid[y][x]= grid[curr[1]][curr[0]] +1;
                    
                hasRotten=true;
               
            }
            
            if(hasRotten && grid[curr[1]][curr[0]] != last){
                last = grid[curr[1]][curr[0]];
                c++;
            }
        }
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                  System.out.println("grid["+i+"]["+j+"]=" +grid[i][j] );
                
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        
        return c;
    }
}