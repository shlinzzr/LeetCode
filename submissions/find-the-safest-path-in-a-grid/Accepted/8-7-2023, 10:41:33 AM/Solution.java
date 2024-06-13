// https://leetcode.com/problems/find-the-safest-path-in-a-grid

class Solution {
    
    int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        
        int h = grid.size();
        int w = grid.get(0).size();
        
        int[][] gd = new int[h][w];
           
        Queue<int[]> q = new LinkedList<>();
        
        for (int i=0; i<h; i++){
            for (int j=0; j<w; j++){
                gd[i][j] = grid.get(i).get(j);
                if (grid.get(i).get(j)==1)
                    q.offer(new int[]{i,j});
            }
        }
        
        while (!q.isEmpty())
        {
            int siz = q.size();
            while (siz>0)
            {
                int[] p = q.poll();
                
                for(int[] d : dirs){
                    
                    int r = p[0]+d[0];
                    int c = p[1]+d[1];
                
                    if(r<0 || c<0 || r>=h || c>=w || gd[r][c]!=0)
                        continue;
                    
                    gd[r][c] = gd[p[0]][p[1]]+1;
                    q.offer(new int[]{r,c});
                }
                siz--;
            }
        }
        
        int left = 0, right = h;
        while (left < right)
        {
            int mid = right-(right-left)/2;
            if (isOK(mid, gd))
                left = mid;
            else
                right = mid-1;
        }
        
        return left;
    }
    
    private boolean isOK(int distance, int[][] gd)
    {
        int h = gd.length;
        int w = gd[0].length;
        
        boolean[][] seen = new boolean[h][w];
        
        if (gd[0][0]<=distance) 
            return false;
        
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0,0});
        seen[0][0] = true;
        
        while (!q.isEmpty())
        {
            
            int[] p = q.poll();
            for(int[] d : dirs)
            {
                int r = p[0]+d[0];
                int c = p[1]+d[1];
                
                if(r<0 || c<0 || r>=h || c>=w || seen[r][c] || gd[r][c]<=distance)
                    continue;
                
                if (r==h-1 && c==w-1) 
                    return true;
                
                seen[r][c] = true; 
                q.offer(new int[]{r,c});
            }
        }
        
        return false;
    }
        
        
//         int h = grid.size();
//         int w = grid.get(0).size();
        
//         List<int[]> list = new ArrayList<>();
        
        
//         for(int i=0; i<h; i++){
//             for(int j=0; j<w; j++){
//                 if(grid.get(i).get(j)==1)
//                     list.add(new int[]{i,j});
//             }
//         }
        
        
//         if(grid.get(0).get(0)==1 || grid.get(h-1).get(w-1)==1)
//             return 0;
        
//         int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        
//         int max =0;
        
//         boolean[][] seen = new boolean[h][w];
        
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{0,0});
//         seen[0][0]=true;
        
//         int min = Integer.MAX_VALUE;
        
//         while(!q.isEmpty()){
            
//             int[] p = q.poll();
            
//             for(int[] d: dirs){
                
//                 int r = p[0]+d[0];
//                 int c = p[1]+d[1];
                
//                 if(r<0 || c<0 || r>=h || c>=w || seen[r][c] || grid.get(r).get(c)==1)
//                     continue;
                
                
//                 for(int[] pt : list){
//                     min = Math.min(min , Math.abs(pt[0]-r) + Math.abs(pt[1]-c));
//                 }
                
//                 // max = Math.max(max, min);
//                 seen[r][c] = true;
//                 q.offer(new int[]{r,c});
//             }
//         }
        
//         return min;
        
//     }
}