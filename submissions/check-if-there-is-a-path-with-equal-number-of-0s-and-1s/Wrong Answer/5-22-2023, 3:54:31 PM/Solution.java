// https://leetcode.com/problems/check-if-there-is-a-path-with-equal-number-of-0s-and-1s

class Solution {
    public boolean isThereAPath(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        if((h*w)%2==1)
            return false;
        
        Queue<int[]> q= new LinkedList<>();
        int offset = grid[0][0]==1? 1: -1;
        q.offer(new int[]{0,0, offset});
        boolean[][] seen = new boolean[h][w];
        
        
        
        seen[0][0]=true;
        
        int[][] dirs = new int[][]{{0,1},{1,0}};
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            int ofs = p[2];
            
            
            for(int[] d : dirs){
                
                int r = d[0]+p[0];
                int c = d[1]+p[1];
                
                if(r>=h || c>=w || (ofs==1 && grid[r][c]==1) || (ofs==-1 && grid[r][c]==0))
                    continue;
                
                int val = ofs+ (grid[r][c]==1? 1 : -1);
                
                if(r==h-1 && c==w-1 && val==0)
                    return true;
                
                seen[r][c]=true;
                q.offer(new int[]{r,c,val});
            }
            
            
        }
        
        return false;
    }
}