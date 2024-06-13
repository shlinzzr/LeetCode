// https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable

class Solution {
    
    int[] parent;
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        Arrays.sort(edges, (a,b)-> b[0]!=a[0] ? b[0]-a[0] : a[1]-b[1]);
        
        parent = new int[n+1];
        for(int i=0; i<n; i++) parent[i] = i;
        int cnt1 = 0;
        int cnt2 = 0;
        int res =0;
        
        for(int[] ed : edges){
            
            if(ed[0]!=3)
                continue;
            
            int root = find(ed[1]);
            int node = find(ed[2]);
            
            if(root!=node){
                parent[node] = root;
                cnt1++;
                cnt2++;
            }else{
                res++;
            }
        }
        
       
        /*for(int[] ed : edges){
            
            if(ed[0]==3)
                continue;
            
            int root = find(ed[1]);
            int node = find(ed[2]);
            
            if(root!=node){
                parent[node] = root;
                cnt--;
            }else{
                res++;
            }
        }*/
        
         int[] parentcpy = parent.clone();
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (union(edge[1], edge[2])) {
                    cnt1++;
                }
                else {
                    res++;
                }
            }
        }
        
        parent = parentcpy;
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (union(edge[1], edge[2])) {
                    cnt2++;
                }
                else {
                    res++;
                }
            }
        }
        
        
        
        return cnt1==n-1 && cnt2==n-1? res : -1;
        
    }
    
     public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return false;
        }
        parent[px] = py;
        return true;
    }
    
    
    private int find(int x){
        if(parent[x]==x)
            return x;
        
        parent[x] = find(parent[x]);
        return parent[x];
    }
}