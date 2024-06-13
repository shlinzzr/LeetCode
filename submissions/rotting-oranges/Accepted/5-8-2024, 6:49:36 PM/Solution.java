// https://leetcode.com/problems/rotting-oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        int f=0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==1)
                    f++;
                
                if(grid[i][j]==2){
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        if(f==0)
            return 0;
        
        
        int step = bfs(grid, queue, f);
        
//         for(int i=0; i<h; i++){
//             for(int j=0; j<w; j++){
                
//                 if(grid[i][j]==1){
//                     return -1;
//                 }
//             }
//         }
        
        return step;
        
        
    }
    
    int[][] dirs = new int[][]{{0,1},{0,-1}, {1,0}, {-1,0}};
    
    private int bfs(int[][] grid, Queue<int[]> queue, int f){
        
        int h = grid.length;
        int w = grid[0].length;
        
        int step=0;
        
        while(!queue.isEmpty()){
            System.out.println(queue.size());
            for(int i=queue.size(); i>0; i--){
                
                int[] p = queue.poll();
                
                for(int[] d : dirs){
                    
                    int r = p[0]+d[0];
                    int c = p[1]+d[1];
                    if(r<0 || r>=h || c<0 || c>=w)
                        continue;
                    
                    if(grid[r][c]==1){
                        f--;
                        grid[r][c]=2;
                        queue.offer(new int[]{r, c});
                    }
                        
                }
            }
            
            step++;
        }
        
        
        
        return f>0? -1 : step-1;

    }
}