// https://leetcode.com/problems/pacific-atlantic-water-flow

class Solution {
    
    Boolean[][] pac;
    Boolean[][] atl;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int h = heights.length;
        int w = heights[0].length;
        
        pac = new Boolean[h][w];
        atl = new Boolean[h][w];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(i==0 || j==0)
                    pac[i][j]=true;
                
                if(i==h-1 || j==w-1)
                    atl[i][j]=true;
            }
         }
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(pac[i][j]!=null && atl[i][j]!=null)
                    continue;
                else{
                    dfs(heights, new int[]{i,j});
                }
            }
        }
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(atl[i][j]!=null && pac[i][j]!=null && atl[i][j]==true && pac[i][j]==true){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        
        
        return res;
        
        
    }
    
    int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    private void dfs(int[][] heights, int[] org){
        int h = heights.length;
        int w = heights[0].length;
        
        boolean[][] seen = new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();
        q.add(org);
        seen[org[0]][org[1]]=true;
        
        while(!q.isEmpty()){
            
            int[] p=q.poll();
            
            for(int[]d: dirs){
                int r = p[0]+d[0];
                int c = p[1]+d[1];

                if(r>=0 && r<h && c>=0 && c<w && seen[r][c]==false && heights[p[0]][p[1]]>=heights[r][c]){

                    if(pac[r][c]!=null && pac[r][c]==true)
                        pac[org[0]][org[1]]=true;

                    if(atl[r][c]!=null && atl[r][c]==true)
                        atl[org[0]][org[1]]=true;

                    
                    if(pac[r][c]!=null && atl[r][c]!=null){
                        seen[r][c]=true;
                        continue;
                    }
                    
                    q.offer(new int[]{r,c});
                    seen[r][c]=true;
                    
                    


                }
            }
            
           
        }
    }
    
}