// https://leetcode.com/problems/redundant-connection

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n =edges.length;
        
        UnionFind uf = new UnionFind(n+1);
        
        List<int[]> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            
            int[] e = edges[i];
            
            int a = uf.find(e[0]);
            int b = uf.find(e[1]);
            
            if(a==b){
                list.add(e);
            }else{
                uf.union(e[0], e[1]);
            }
        }
        
        return list.get(list.size()-1);
        
        
        
    }
    
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
            
            if(weight[a]<=weight[b]){
                weight[a]+=weight[b];
                parent[b] = a;
            }else{
                weight[b]+=weight[a];
                parent[a] = b;
            }
        }
        
    }
    
}

