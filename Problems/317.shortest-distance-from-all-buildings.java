// https://leetcode.com/problems/shortest-distance-from-all-buildings

public class Solution {
    
    
    private int[] getHouse(int[][] grid, HashSet<int[]> buildings){
        int h = grid.length;
        int w = grid[0].length;
        
        boolean[][][][] seen = new boolean[h][w][h][w]; // seen[i][j][k][l] 以i j出發的有沒有走過k l
        
        Queue<int[]> q= new LinkedList<>();
        
        int emptyLand = 0;
        
        for(int i=0; i<h;i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==1){
                    buildings.add(new int[]{i, j});
                    q.offer(new int[]{i, j, i, j}); // 從i j 出發的 目前走到i j
                    seen[i][j][i][j] = true;   
                }else if(grid[i][j]==2){
                    grid[i][j]=-1;
                }else
                    emptyLand++;
            }
        }
        
        // if(emptyLand==0)
        //     return null;
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        int[] house = null;
        
        int step = 0;
        while(!q.isEmpty()){
            int siz = q.size();
            
            while(siz-->0){
                
                int[] p = q.poll();
                
                for(int[] d: dirs){
                    
                    int i = p[0];
                    int j = p[1];
                    int k = d[0]+p[2];
                    int l = d[1]+p[3];
                    
                    
                    if(k<0 || l<0 || k>=h || l>=w || seen[i][j][k][l] || grid[k][l]==-1)
                        continue;
                    
                    grid[k][l]++;
                    // System.out.println(i+" "+j + " " + k + " " + l + " grid[k][l]="+grid[k][l] + " building="+buildings.size());
                    
                    if(grid[k][l]==buildings.size()){
                        house = new int[]{k, l};    
                        return house;
                    }
                    
                    seen[i][j][k][l] = true;
                    q.offer(new int[]{i,j, k, l});
                }
            }
            step++;
        }
        
        return house;
    }
    
    
    
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;

          
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        
        int h = grid.length;
        int w = grid[0].length;
        
        int[][] distance = new int[h][w];
        int[][] reach = new int[h][w];
        int buildingNum = 0;
        
        for(int i=0; i<h;i++){
            for(int j=0; j<w; j++){
                if (grid[i][j] == 1) {
                    buildingNum++;
                    Queue<int[]> q = new LinkedList<int[]>();
                    q.offer(new int[] {i,j});

                    boolean[][] seen = new boolean[h][w]; 
                    int step = 1;
                    
                    while (!q.isEmpty()) {
                        int siz = q.size();
                        while(siz-->0){
                            int[] p = q.poll();
                            
                            for(int[] d : dirs){
                                int r = p[0] + d[0];
                                int c = p[1] + d[1];
                                
                                if(r<0 || c<0 || r>=h || c>=w || seen[r][c] || grid[r][c]!=0)
                                    continue;
                                
                                distance[r][c] += step;
                                reach[r][c]++;

                                seen[r][c] =true;
                                q.offer(new int[]{r,c});
                            }
                        }
                        step++;
                    }
                }
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
        
        
    }
}