// https://leetcode.com/problems/number-of-provinces

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        
        int w = isConnected[0].length;
      
        UnionFind uf = new UnionFind(len);
        int cnt=len;
        
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<w; j++){
                
                if(isConnected[i][j]==1){
                    
                    int a = uf.find(i);
                    int b = uf.find(j);
                    
                    if(a!=b){
                        uf.union(a,b);
                        cnt--;
                    }
                        
                }
                
                
            }
            
            
        }
        
        
        
        return cnt;
            
            
        
        
        
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
        
        
        public void union(int a, int b){
            
            a = find(a);
            b = find(b);
            
            if(a==b)
                return ;
            
            if(weight[a]>= weight[b]){
                weight[a]+=weight[b];
                parent[b] = a;
            }else{
                weight[b]+=weight[a];
                parent[a] = b;
            }
            
            
        }
        
        
        public int find(int x){
            if(parent[x] ==x)
                return x;
            
            parent[x] = find(parent[x]);
            return parent[x];
        }
        
        
    }
}