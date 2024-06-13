// https://leetcode.com/problems/number-of-provinces

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        
        UnionFind uf = new UnionFind(len);
        int res =len;
        for(int i=0; i<len; i++){
            
            int[] row = isConnected[i];
            for(int j=i+1; j<len; j++){
                
                if(isConnected[i][j]==1){
                    
                    int root = uf.find(i);
                    int node = uf.find(j);
                    
                    if(root!=node){
                        
                        uf.parent[node] = root;
                        res--;
                    }
                }
            }
        }
        
        return res;
            
            
        
        
        
    }
    
    
    
    class UnionFind{
        
        
        int[] parent;
        int[] weight;
        
        public UnionFind(int n){
            
            parent = new int[n];
            weight = new int[n];
            
            for(int i=0; i<n; i++)
                parent[i]=i;
        }
        
        
        public int find(int x){
            if(parent[x] ==x)
                return x;
            
            parent[x] = find(parent[x]);
            return parent[x];
        }
        
        
    }
}