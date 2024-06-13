// https://leetcode.com/problems/walls-and-gates

class Solution {
    public void wallsAndGates(int[][] rooms) {
         int h = rooms.length;
        int w = rooms[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] bool = new boolean[h][w];
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,-1}, {0,1}};
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(rooms[i][j]==0){
                    q.offer(new int[]{i,j});
                    bool[i][j]=true;
                }
                
                if(rooms[i][j]==-1)
                    bool[i][j]=true;
            }
        }
        
        int step = 1;
        while(!q.isEmpty()){
            
            int siz = q.size();
            for(int i=siz; i>0; i--){
                int[] p = q.poll();
                
                for(int[] d : dirs){
                    
                    int r = p[0]+d[0];
                    int c = p[1]+d[1];
                    
                    if(r<0 || r>=h || c<0 || c>=w || bool[r][c]==true)
                        continue;
                    
                    q.offer(new int[]{r,c});
                    bool[r][c]=true;
                    rooms[r][c]=step;
                }
            }
            step++;
        }
        
        
    }
}




// [[2,-1,0,1],
//  [2,1,1,-1],
//  [1,-1,1,-1],
//  [0,-1,2,3]]