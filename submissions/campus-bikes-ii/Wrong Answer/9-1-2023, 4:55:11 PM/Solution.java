// https://leetcode.com/problems/campus-bikes-ii

class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int len_w = workers.length;
        int len_b = bikes.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(  // widx, bidx, distance
            (a,b) -> a[2] - b[2]
        );
        
        
        boolean[] bike_seen = new boolean[len_b];
        boolean[] worker_seen = new boolean[len_w];
        
        
        HashSet<String> bike = new HashSet<>();
        
        for(int i=0; i<len_w; i++){
            
            for(int j=0; j<len_b; j++){
                
                int[] w = workers[i];
                int[] b = bikes[i];
                
                int distance = Math.abs(w[0]-b[0]) + Math.abs(w[1]-b[1]);
                pq.offer(new int[]{i, j, distance});
            }
        }
        
        int res = 0;
        
        int cnt =0;
        while(cnt<len_w){
            
            while(!pq.isEmpty()){
                int[] p = pq.poll();
                
                int widx = p[0];
                int bidx = p[1];
                int distance = p[2];
                
                if(worker_seen[widx]==false && bike_seen[bidx]==false){
                    worker_seen[widx]=true;
                    bike_seen[bidx]=true;
                    res += distance;
                    break;
                }
            }
            
            cnt++;
        }
        
        return res;
    }
}