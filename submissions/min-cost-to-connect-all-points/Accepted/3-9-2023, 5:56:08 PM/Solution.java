// https://leetcode.com/problems/min-cost-to-connect-all-points

class Solution {
    
   /* public int minCostConnectPoints(int[][] points) {
        
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
        while(pq.isEmpty()){
            
            int[] p = pq.poll();
            
            int i = p[1];
            int j = p[2];
            
            if(uf.find(i)!=uf.find(j)){
                res += p[0];
                uf.union(i, j);
            }
        }
        return res;
        
        
        
    }*/
    
     public int minCostConnectPoints(int[][] points) {
        int n = points.length, ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                 pq.add(new int[]{ findDist(points, i, j), i, j });
            }
        }
        int count = 0;
        UnionFind uf = new UnionFind(n);
        while(count < n-1) {
            int[] edge = pq.poll();
            if(uf.find(edge[1]) != uf.find(edge[2])) {
                ans += edge[0];
                count++;
                uf.union(edge[1], edge[2]);
            }
        }
        return ans;
    }
    
   private int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
    
    class UnionFind{
        
        int[] parent;
        
        public UnionFind(int n){
            this.parent = new int[n];
            for(int i=0; i<n; i++){
                parent[i]=i;
            }
        }
        
        public void union(int a, int b){
            
            parent[find(a)] = parent[find(b)];
            
//             int rootA = find(a);
//             int rootB = find(b);
            
//             if(rootA==rootB)
//                 return;
            
//             parent[rootA]=rootB;
        }
        
        public int find(int x){
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            
            return parent[x];
        }
    }
}