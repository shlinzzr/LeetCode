// https://leetcode.com/problems/min-cost-to-connect-all-points

class Solution {
       
    
    // Kruskal's algo
    int[] parent;
    public int minCostConnectPoints(int[][] points) {
        
        int len = points.length;
        
        parent = new int[len];
        for(int i=0; i<len; i++){
            parent[i] = i;
        }
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[2]-b[2]
        );
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                
                int[] a = points[i];
                int[] b = points[j];
                
                int dis = Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
                
                pq.offer(new int[]{i, j, dis});
            }
        }
        
        int cnt=  0;
        int res = 0;
        while(cnt<len-1){
            int[] p = pq.poll();
            int a = p[0];
            int b = p[1];
            int dis = p[2];
            
            if(union(a,b)){
                res+= p[2];
                cnt++;
            }
        }
        
        return res;
    }
    
    private int find(int x){
        if(x!=parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    private boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return false;
        
        if(a<b)
            parent[b] = a;
        else 
            parent[a] = b;
        return true;
    }
}