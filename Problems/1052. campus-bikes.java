// https://leetcode.com/problems/campus-bikes

class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        
     
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(  // widx, bidx, distance
            (a,b) -> a[2]!=b[2] ? a[2]-b[2] : a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]
        );
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                int wx = workers[i][0];
                int wy = workers[i][1];
                int bx = bikes[j][0];
                int by = bikes[j][1];
                
                int distance = Math.abs(wx-bx) + Math.abs(wy-by);
                
                pq.offer(new int[]{i, j, distance});
            }
        }
        
        boolean[] wseen = new boolean[n];
        boolean[] bseen = new boolean[m];
        
        int[] res = new int[n];
        
        int cnt =0;
        
        while(cnt<n){
            
            boolean found=false;
            while(found==false){
                
                int[] p = pq.poll();
                
                int wi = p[0];
                int bi = p[1];
                
                
                if(wseen[wi] || bseen[bi])
                    continue;
                
                
                if(wseen[wi]==false && bseen[bi]==false){
                    
                    found=true;
                    wseen[wi]=true;
                    bseen[bi]=true;
                    res[wi]=bi;
                }
            }
            
            cnt++;
        }
        
        return res;
        
    }
    
}
