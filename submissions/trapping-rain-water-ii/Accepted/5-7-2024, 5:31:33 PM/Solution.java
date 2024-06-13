// https://leetcode.com/problems/trapping-rain-water-ii

class Solution {
    public int trapRainWater(int[][] heightMap) {
        /*
        [[1,4,3,1,3,2]
        ,[3,2,1,3,2,4]
        ,[2,3,3,2,3,1]]
        */
        //從外面一圈開始 用pq從最矮的牆流進去 找trap water

        PriorityQueue<int[]> pq = new PriorityQueue<>( // r, c, height
            (a,b) -> a[2]-b[2] // sort by height asc
        );
            
        int h = heightMap.length;
        int w = heightMap[0].length;
        
        boolean[][] visited = new boolean[h][w];
        
        // deal edge first
        for(int i=0; i<h; i++){
            visited[i][0]=true;
            visited[i][w-1]=true;
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, w-1, heightMap[i][w-1]});
        }
        
         // deal edge first
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
                
                // 只看edge裡面一圈
                if(r>0 && c>0 && r<h-1 && c<w-1 && visited[r][c]==false ){
                    visited[r][c]=true;
                    pq.offer(new int[]{r, c, Math.max(cell[2], heightMap[r][c])});
                    int val  = Math.max(0, cell[2]-heightMap[r][c]);
                    res += val;
                }
            }
        }
        return res;
        
    }
      /*

    [ 0 0 0 0]
    [ 0 8 0 0]
    [ 0 4 2 0]
    [ 0 0 0 0]
    [ 0 0 0 0]

    */

// 高度最小的先 

        /*
    [[12,13,1,12]
    ,[13,"4",13,12].  水位會流成8
    ,[13,8,10,12]
    ,[12,13,12,12]
    ,[13,13,13,13]]


    [ 0 0 0 0]
    [ 0 9 0 0]
    [ 0 5 2 0]
    [ 0 0 0 0]
    [ 0 0 0 0]

    */

}