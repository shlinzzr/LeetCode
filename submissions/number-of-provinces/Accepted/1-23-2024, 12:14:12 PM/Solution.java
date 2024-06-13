// https://leetcode.com/problems/number-of-provinces

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isConnected[i][j]==1 && find(parent, i)!=find(parent, j)){
                    union(parent, i, j);
                }
            }
        }
        
        int res = 0;
        for(int i=0; i<n; i++){
            if(parent[i]==i)
                res++;
        }
        
        return res;
    }
    
    private void union(int[] parent, int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        
        if(a==b) return ;
        
        if(a<b){
            parent[b] = a;
        }else 
            parent[a] = b;
    }
    
    private int find(int[] parent, int x){
        
        if(parent[x]!=x){
            return find(parent, parent[x]);
        }
        
        return parent[x];
    }
}