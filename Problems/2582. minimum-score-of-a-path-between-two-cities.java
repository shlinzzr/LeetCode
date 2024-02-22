// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities

class Solution {
    public int minScore(int n, int[][] roads) {
        
        UnionFind uf = new UnionFind(n+1);
        
        int len = roads.length;
        
        
        for(int i=0; i<len; i++){
            
            int a = roads[i][0];
            int b = roads[i][1];
            int dis = roads[i][2];
            
            if(uf.find(a)!=uf.find(b)){
                uf.union(a, b, dis);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i=0; i<len; i++){
            
            
            if(uf.find(1)==uf.find(roads[i][0]))
                ans = Math.min(ans, roads[i][2]);
        }
        
        return ans;
    }
    
    
    class UnionFind{
        
        int[] parent;
        int[] weight;
        
        public UnionFind(int n){
            parent = new int[n];
            weight = new int[n];
            Arrays.fill(weight, -1);
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
            
        }
        
        public int find(int x){
            if(parent[x] == x)
                return x;
            parent[x] = find(parent[x]);
            
            return parent[x];
        }
        
        
        public void union(int a, int b, int w){
            int ra = find(a);
            int rb = find(b);
            
            if(ra==rb)
                return ;
            
            if(ra<=rb){
                parent[rb] = ra;
                weight[rb] = Math.min(weight[rb], w);
            }else{
                parent[ra] = rb;
                weight[ra] = Math.min(weight[ra], w);
            }
            
        }
        
    }
}