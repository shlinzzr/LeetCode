// https://leetcode.com/problems/find-the-safest-path-in-a-grid

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        
        int h = grid.size();
        int w = grid.get(0).size();

        int[][] sf = new int[h][w];
              for(int i=0; i<h; i++){ Arrays.fill(sf[i], h+w);}

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(grid.get(i).get(j)==1){
                    sf[i][j] = 0;
                    dfs(grid, sf, i, j);
                }
            }
        }
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                System.out.print(sf[i][j]+ ",");
            }
            System.out.println();
        }
        

        int[][] dis = new int[h][w];
        dis[0][0] = sf[0][0];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0, sf[0][0]});

        while(!q.isEmpty()){
            
            int[] p = q.poll();
            int distance = p[2];

            for(int[] d : dirs){
                int r = d[0]+p[0];
                int c = d[1]+p[1];
                

                if(r<0 || c<0 || r>=h || c>=w)
                    continue;

                int minD = Math.min(distance, sf[r][c]);

                if(dis[r][c]>=minD)
                    continue;
                
                q.offer(new int[]{r,c, minD});
                dis[r][c] = minD;
            }
        }

        return dis[h-1][w-1];




    }
    int[][] dirs = new int[][]{{1,0},{0, 1}, {-1,0}, {0,-1}};
    private void dfs(List<List<Integer>> grid, int[][] sf, int i, int j){
        int h = grid.size();
        int w = grid.get(0).size();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        int step= 0;

        while(!q.isEmpty()){
            step++;
            int size = q.size();
            while(size-->0){
                int[] p = q.poll();

                for(int[] d : dirs){
                    int r = p[0]+d[0];
                    int c = p[1]+d[1];
                    //  if(r<0 || c<0 || r>=h || c>=w ) continue;
                        // System.out.println(p[0] + " "+p[1] + "__>" + r+ " "+c +" step=" + step+ " sf[r][c="+ sf[r][c]);
                    if(r<0 || c<0 || r>=h || c>=w || sf[r][c]<=step || grid.get(r).get(c)==1)
                        continue;

                        

                    q.offer(new int[]{r,c});
                    sf[r][c] = step;
                }
            }
        }

    }



}