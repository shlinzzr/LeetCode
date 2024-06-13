// https://leetcode.com/problems/shortest-distance-from-all-buildings

class Solution {
    public int shortestDistance(int[][] grid) {
       
        
        HashSet<String> buildings = new HashSet<>();
        int[] h = getHouse(grid, buildings);
        if(h==null)
            return -1;
        
        System.out.println(h[0] + " " + h[1]);
        
        int res= 0;
        for(String bul : buildings){
            
            String[] arr = bul.split("_");
            int y = Integer.valueOf(arr[0]);
            int x = Integer.valueOf(arr[1]);
            
            res += Math.abs(h[0]-y) + Math.abs(h[1]-x);
        }
        
        return res;
        
        
    }
    
    private int[] getHouse(int[][] grid, HashSet<String> buildings){
        int h = grid.length;
        int w = grid[0].length;
        
        boolean[][][][] seen = new boolean[h][w][h][w]; // seen[i][j][k][l] 以i j出發的有沒有走過k l
        
        Queue<int[]> q= new LinkedList<>();
        
        int emptyLand = 0;
        
        for(int i=0; i<h;i++){
            for(int j=0; j<w; j++){
                
                if(grid[i][j]==1){
                    buildings.add(i+"_"+j);
                    q.offer(new int[]{i, j, i, j}); // 從i j 出發的 目前走到i j
                    seen[i][j][i][j] = true;   
                }else if(grid[i][j]==2){
                    grid[i][j]=-1;
                }else
                    emptyLand++;
            }
        }
        
        // System.out.println("buildings=" + buildings);
        
        if(emptyLand==0)
            return null;
        
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
                    
                    
                    if(k<0 || l<0 || k>=h || l>=w || seen[i][j][k][l] || grid[k][l]==-1 || seen[k][l][k][l])
                        continue;
                    
                    grid[k][l]++;
                    // System.out.println(i+" "+j + " " + k + " " + l + " grid[k][l]="+grid[k][l] + " building="+buildings.size());
                    
                    if(grid[k][l]==buildings.size() && !buildings.contains(k+"_"+l)){
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
}