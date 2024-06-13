// https://leetcode.com/problems/number-of-operations-to-make-network-connected

class Solution {
    
    class UnionFind{
        
        int[] parent;
        
        public UnionFind(int n ){
            parent = new int[n];
            
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }
        
        public int find(int x){
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        
        public void union(int a, int b){
            
            a= find(a);
            b= find(b);
            
            if(a==b)
                return;
            else{
                if(a<b){
                    parent[b] = a;
                }else{
                    parent[a]=b;
                }
            }
        }
    }
    
    
    public int makeConnected(int n, int[][] connections) {
        
        UnionFind uf = new UnionFind(n);
        
        int len = connections.length;
        
        if(len<n-1)
            return -1;
        
        int cnt=0;
        for(int i=0; i<len; i++){
            int[] con = connections[i];
            
            int a = con[0];
            int b = con[1];
            
            if(uf.find(a)!=uf.find(b)){
                uf.union(a, b);
                // cnt++;
            }
        }
        
        for(int i=0; i<n; i++){
            if(uf.parent[i]!=0)
                cnt++;
        }
        
        return cnt;
    }
}