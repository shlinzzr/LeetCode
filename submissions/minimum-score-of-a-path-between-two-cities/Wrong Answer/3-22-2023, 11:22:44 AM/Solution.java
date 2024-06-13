// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities

class Solution {
    
    class UnionFind{
        
        int[] parent;
        int[] weight;
        
        public UnionFind(int n){
            parent = new int[n];
            weight = new int[n];
        }
        
        public int find(int x){
            
            if(parent[x]==x)
                return x;
            
            parent[x] = find(parent[x]);
            
            return parent[x];
        }
        
        public void union(int a, int b){
            
            if(find(a)==find(b))
                return;
            
            if(weight[a] >= weight[b]){
                weight[a] += weight[b];
                parent[b] = a;
            }else{
                weight[b] += weight[a];
                parent[a] = b;
            }
        }
        
    }
    
    
    
    public int minScore(int n, int[][] roads) {
        
        UnionFind uf = new UnionFind(n+1);
        for(int i=0; i<=n; i++){
            uf.parent[i]= i;
        }
        
        
        for(int[] r : roads){
            if(uf.find(r[0])!=uf.find(r[1]))
                uf.union(r[0], r[1]);
        }
        
        int min = Integer.MAX_VALUE;
        for(int[] r : roads){
            
            if(uf.find(r[0])==uf.find(1)){
                min = Math.min(min, r[2]);
            }
        }
        
        return min;
    }
}