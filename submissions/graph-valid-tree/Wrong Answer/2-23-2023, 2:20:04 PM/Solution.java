// https://leetcode.com/problems/graph-valid-tree

class Solution {
    int[] uf;
    
    public boolean validTree(int n, int[][] edges) {
        uf = new int[n];
        for(int i=0; i<n; i++){
            uf[i]=i;
        }
        
        for(int[] e : edges){
            
            int root = find(e[0]);
            int node = find(e[1]);
            
            if (root == node) return false;
            
            uf[node] = root;
        }
        
         // return edges.length == n - 1;
        return true;
        
        
    }
    
    private int find(int x){
        if(uf[x]==x)
            return x;
        
        uf[x] = find(uf[x]);
        
        return uf[x];
    }
}