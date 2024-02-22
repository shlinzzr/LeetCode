// https://leetcode.com/problems/min-cost-to-connect-all-points

class Solution {
    
    public int minCostConnectPoints(int[][] points) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );
        int len = points.length;
            
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                pq.offer(new int[]{getDis(points[i], points[j]), i, j});
            }
        }
        
        UnionFind uf = new UnionFind(len);
        
        int res =0;
        int cnt=0;
        while(cnt<len-1){
            
            int[] p = pq.poll();
            
            int i = p[1];
            int j = p[2];
            
            if(uf.find(i)!=uf.find(j)){
                res += p[0];
                uf.union(i, j);
                cnt++;
            }
        }
        return res;
        
        
        
    }
    
    private int getDis(int[] p1, int[] p2){
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
    
    class UnionFind{
        
        int[] parent;
        
        public UnionFind(int n){
            this.parent = new int[n];
            for(int i=0; i<n; i++){
                parent[i]=i;
            }
        }
        
        public void union(int a, int b) {
            parent[find(a)] = parent[find(b)];
        }
        
        public int find(int x){
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            
            return parent[x];
        }
    }
}