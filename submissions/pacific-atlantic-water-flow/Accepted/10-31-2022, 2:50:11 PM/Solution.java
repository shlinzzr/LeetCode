// https://leetcode.com/problems/pacific-atlantic-water-flow

class Solution {
    
    int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    boolean[][] pac;
    boolean[][] atl;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        
        int h = heights.length;
        int w = heights[0].length;
        
        pac = new boolean[h][w];
        atl = new boolean[h][w];
        
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
                    
                if(pac[i][j] && atl[i][j])
                    continue;
                else 
                    dfs(new int[]{i,j}, h, w, heights);
            }
        }
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(pac[i][j] && atl[i][j]){
                    
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        
        return res;
        
        
       
        
       
        
    }
    
    private void dfs(int[] st, int h, int w, int[][] heights){
        
        boolean[][] seen = new boolean[h][w];
        seen[st[0]][st[1]]=true;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{st[0], st[1]});
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            
            int i=p[0];
            int j=p[1];
            
            for(int[] d : dirs){
                int r = p[0]+d[0];
                int c = p[1]+d[1];
                
                if(r>=0 && r<h && c>=0 && c<w && seen[r][c]==false && heights[p[0]][p[1]]>=heights[r][c]){
                    
                    if(pac[r][c]==true)
                        pac[st[0]][st[1]]=true;

                    if(atl[r][c]==true)
                        atl[st[0]][st[1]]=true;

                    if(pac[r][c]&&atl[r][c]){
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