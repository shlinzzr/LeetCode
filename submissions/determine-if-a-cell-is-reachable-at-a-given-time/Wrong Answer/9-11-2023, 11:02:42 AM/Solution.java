// https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time

class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        Queue<int[]> q= new LinkedList<>();
        Set<String> set= new HashSet<>();
        q.offer(new int[]{sy, sx});
        set.add(sy+"_"+sx);
        
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}, {1,1}, {-1,1}, {1,-1},{-1,-1}};
        
        
        while(!q.isEmpty() && t>0){
            
            int siz = q.size();
            while(siz-->0){
                
                int[] p = q.poll();
                
                for(int[] d: dirs){
                    
                    int r = p[0]+d[0];
                    int c = p[1]+d[1];

                    if(r==fy &&c==fx)
                        return true;

                    if(set.contains(r+"_"+c))
                        continue;

                    q.offer(new int[]{r,c});
                    
                }
            }
            
            t--;
        }
        
        
        return false;
        
        
    }
}