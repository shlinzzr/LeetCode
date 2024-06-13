// https://leetcode.com/problems/find-if-path-exists-in-graph

class Solution {
    
    int[] parent;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent= new int[n];
        
        for(int i=0; i<n ;i++){
            parent[i] =i ;
        }
        
        for(int[] e : edges){
            union(e[0], e[1]);
        }
        
        return parent[source] == parent[destination];
    }
    
    
    private int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    private void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a==b) return;
        
        if(a<b){
            parent[b] = a;
        }
        else 
            parent[a] = b;
    }
}