// https://leetcode.com/problems/campus-bikes

class Solution {
    
    class Pair {
        int[] w;
        int[] b;
        int dis;
        int wi;
        int bi;
        
        public Pair(int[] w, int wi, int[] b, int bi){
            this.w=w;
            this.b=b;
            this.wi=wi;
            this.bi=bi;
            this.dis = Math.abs(w[0]-b[0]) + Math.abs(w[1]-b[1]);
        }
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        
        int n = workers.length;
        int m = bikes.length;
        
        boolean[] seen_w = new boolean[n];
        boolean[] seen_b = new boolean[m];
        
        int[] ans = new int[n];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)-> (a.dis!=b.dis ? a.dis-b.dis : (a.wi!=b.wi ? a.wi-b.wi : a.bi-b.bi))
        );
            
        
      
        for(int i=0; i<n; i++){ // workers
            for(int j=0; j<m; j++){ // bike0 assign to
                // if(seen_b[j]) continue;
                Pair p = new Pair(workers[i], i, bikes[j], j);
                pq.offer(p);
            }
        }
        
        for(int i=0; i<n; i++){ // workers
            Pair p = pq.poll();
            while(seen_w[p.wi] || seen_b[p.bi]){
                p = pq.poll();
            }
            ans[p.wi] = p.bi;
            seen_w[p.wi]=true;
            seen_b[p.bi]=true;
        }
        return ans;
        
        
        
    }
}