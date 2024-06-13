// https://leetcode.com/problems/graph-valid-tree

class Solution {
    int[] parent;
    
    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            if(union(a,b)==false)return false;
        }
        
        for(int i = 0; i<n; i++){
            if(find(i)!=0) return false;
        }
        
        return true;
    }
    
    private int find(int x){
        // if(parent[x]!=x) parent[x] = find(parent[x]);
        // return parent[x];
        
        return (x==parent[x] ? x : (parent[x] = find(parent[x])));
    }
    
    private boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return false;
        
        if(a<b){
            parent[b] = a;
            
        }else 
            parent[a] = b;
        
        return true;
    }
}