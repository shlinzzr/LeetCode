// https://leetcode.com/problems/rotting-oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();
        
        int h = grid.length;
        int w = grid.length;
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[j][i]==2)
                    queue.offer(new int[]{j,i});
            }
        }
        
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
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
                hasRotten=true;
                grid[y][x]=2;
            }
            
            if(hasRotten) c++;
        }
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid[j][i]==1)
                    return -1;
            }
        }
        
        return c;
    }
}