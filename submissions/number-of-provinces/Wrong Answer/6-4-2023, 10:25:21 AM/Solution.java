// https://leetcode.com/problems/number-of-provinces

class Solution {
    int[] parent;
    int[] weight;
    
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                
                int val = isConnected[i][j];
                
                if(val==1){
                    n--;
                    
                    // int a = find(i);
                    // int b = find(j);
                }
                
            }
        }
        
        return n;
    }

    private int find(int a){
        
        if(parent[a]!=a){
            parent[a]=find(parent[a]);
            
        }
        
        return parent[a];
    }
    
    private void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a==b)
            return;
        
        parent[b] = a;
    }
}