// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph

class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        int cnt = n;
        for(int[] e : edges){
            
            int root = find(parent, e[0]);
            int node = find(parent, e[1]);
            
            if(root!=node){
                parent[node] = root;
                cnt--;
            }
        }
        return cnt;
    }
    
    private int find(int[] parent, int x){
        if(parent[x]==x)
            return x;
        
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}