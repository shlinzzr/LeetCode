// https://leetcode.com/problems/number-of-operations-to-make-network-connected

class Solution {
    int[] parent;
    public int makeConnected(int n, int[][] connections) {
        Arrays.sort(connections, (a, b)-> a[0]-b[0]);
       
        if(connections.length<n-1)
            return -1;
        
        int cnt = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for(int[] con : connections){
            
            int root = find(con[0]);
            int node = find(con[1]);
            
            if(root!=node){
                cnt--;
                parent[node]= root;
            }
            
        }
        
        return cnt-1;
            
        
    }
    
    private int find(int x){
        if(parent[x]==x)
            return x;
        parent[x] =  find(parent[x]);
        return parent[x];
    }
}