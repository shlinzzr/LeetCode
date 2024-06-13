// https://leetcode.com/problems/find-the-safest-path-in-a-grid

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int h = grid.size();
        int w = grid.get(0).size();
        
        List<int[]> list = new ArrayList<>();
        
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                if(grid.get(i).get(j)==1)
                    list.add(new int[]{i,j});
            }
            
        }
        
        
        if(grid.get(0).get(0)==1 || grid.get(h-1).get(w-1)==1)
            return 0;
        
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        int max =0;
        
        boolean[][] seen = new boolean[h][w];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            
            for(int[] d: dirs){
                
                int r = p[0]+d[0];
                int c = p[1]+d[1];
                
                if(r<0 || c<0 || r>=h || c>=w || seen[r][c] || grid.get(r).get(c)==1)
                    continue;
                
                int min = Integer.MAX_VALUE;
                for(int[] pt : list){
                    min = Math.min(min , Math.abs(pt[0]-r) + Math.abs(pt[1]- c));
                }
                
                max = Math.max(max, min);
                q.offer(new int[]{r,c});
            }
        }
        
        return max;
        
    }
}