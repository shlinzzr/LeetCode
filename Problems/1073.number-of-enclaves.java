// https://leetcode.com/problems/number-of-enclaves

class Solution {
    public int numEnclaves(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        int oneCnt = 0;
        
        boolean[][] seen = new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();
                
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==1){
                    oneCnt++;
                    if(i==0 || i==h-1 || j==0 || j==w-1){
                        
                        seen[i][j]=true;
                        q.offer(new int[]{i, j});
                        oneCnt--;
                    }
                }
            }
        }
        
        System.out.println(oneCnt);
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            for(int[] d : dirs){
                int r = p[0]+d[0];
                int c = p[1]+d[1];
                
                if(r<0 || r>=h || c<0 || c>=w || seen[r][c] || grid[r][c]!=1)
                    continue;
                
                seen[r][c] = true;
                oneCnt--;
                q.offer(new int[]{r, c});
            }
        }
        return oneCnt;
    }
    
    int[][] dirs = new int[][]{{0,1}, {1,0}, {0, -1}, {-1, 0}};
}