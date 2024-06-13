// https://leetcode.com/problems/number-of-provinces

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = n;
        int[] parent = new int[n];
        
        for(int i=0; i<n; i++) parent[i]=i;
        
        
        
        int[] weight = new int[n];
        Arrays.fill(weight, 1);
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                
                if(isConnected[i][j]==1){
                    
                    int root = find(parent, i);
                    int node = find(parent, j);
                    
                    if(root!=node){
                        
                        weight[root] += weight[node];
                        parent[node] = root;
                        provinces--;
                    }
                }
            }
        }
        
        return provinces;
        
        
    }
    
    private int find(int[] parent, int x){
        if(parent[x]==x)
            return x;
        
        parent[x] = find(parent, parent[x]);
        return parent[x];
        
    }
}