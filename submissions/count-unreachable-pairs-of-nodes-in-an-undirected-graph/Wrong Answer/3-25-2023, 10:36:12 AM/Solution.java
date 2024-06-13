// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph

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
            Arrays.fill(weight, 1);
        
        }
        public int find(int x){
            
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            
            return parent[x];
        }
        
        public void union(int a, int b){

            a=find(a);
            b=find(b);
            
            if(a==b)
                return;
            
            if(a<b){
                weight[a]+=weight[b];
                parent[b] = a;
            }else{
                weight[b]+=weight[a];
                parent[a] = b;
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        long cnt=0;
        
        for(int i=0; i<edges.length; i++){
            
            int a = uf.find(edges[i][0]);
            int b = uf.find(edges[i][1]);
            
            if(a!=b){
                uf.union(a,b);
                // cnt--;
            }
            
        }
        
        for(int i=0; i<n; i++){
            
            if(uf.parent[i]==i){
                // System.out.println(uf.weight[i]+" "+ i);
                cnt+= (long)uf.weight[i] * (long)(n-uf.weight[i]);
            }
            
        }
        
        return cnt;
    }
}