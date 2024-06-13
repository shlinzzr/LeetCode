// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities

class Solution {
    
    class UnionFind{
        
        int[] parent;
        int[] weight;
        
        public UnionFind(int n){
            parent = new int[n];
            weight = new int[n];
            for(int i=0; i<n; i++){
                parent[i]= i;
            }
        
        }
        
        public int find(int x){
            
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            
            return parent[x];
        }
        
        public void union(int a, int b){
            
            if(find(a)==find(b))
                return;
            
            // if(weight[a] >= weight[b]){
            if(find(a)<find(b)){
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
      
        
        for(int[] r : roads){
            int a = r[0], b=r[1];
            if(uf.find(a)!=uf.find(b))
                uf.union(a, b);
        }
        
        int min = Integer.MAX_VALUE;
        for(int[] r : roads){
            int a = r[0], b=r[1], d=r[2];
            if(uf.find(a)==uf.find(1) || uf.find(b)==uf.find(1)){
                min = Math.min(min, d);
            }
        }
        
        return min;
    }
}