// https://leetcode.com/problems/trapping-rain-water-ii

class Solution {
    public int trapRainWater(int[][] heightMap) {
        /*
        [[1,4,3,1,3,2]
        ,[3,2,1,3,2,4]
        ,[2,3,3,2,3,1]]
        */
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1,o2) -> o1[2]-o2[2]
        );
            
        int h = heightMap.length;
        int w = heightMap[0].length;
        
        boolean[][] visited = new boolean[h][w];
        
        
        for(int i=0; i<h; i++){
            visited[i][0]=true;
            visited[i][w-1]=true;
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, w-1, heightMap[i][w-1]});
        }
        
        for(int j=0; j<w; j++){
            visited[0][j]=true;
            visited[h-1][j]=true;
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{h-1, j, heightMap[h-1][j]});
        }
        
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        int res = 0;
        while(!pq.isEmpty()){
            
            int[] cell = pq.poll();
            
            for(int[] d : dirs){
                
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                
                if(r>0 && c>0 && r<h-1 && c<w-1 && visited[r][c]==false && heightMap[r][c]<cell[2]){
                    visited[r][c]=true;
                    pq.offer(new int[]{r,c,heightMap[r][c]});
                    res += cell[2]-heightMap[r][c];
                }
            }
        }
        return res;
        
            
            
            
            
            
        
    }
}
