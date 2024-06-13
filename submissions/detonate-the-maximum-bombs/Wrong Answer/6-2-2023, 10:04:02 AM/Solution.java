// https://leetcode.com/problems/detonate-the-maximum-bombs

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int len = bombs.length;
        
        UnionFind uf = new UnionFind(len);
        
        for(int i=0; i<len; i++){
            
            for(int j=i+1; j<len; j++){
                
                int[] a = bombs[i];
                int[] b = bombs[j];
                
                boolean ir = inRange(a, b);
                
                // System.out.println(i + " "  + j + " " + ir);
                
                
                if(ir){
                    uf.union(i, j);
                }
            }
        }
        
//         for(int i=0; i<len; i++){
//             System.out.println("i="+i + " " + uf.parent[i]);
//         }
        
        
        return uf.max;
        
    }
    
    
    private boolean inRange(int[] a, int[] b){
        
        int ax = a[0];
        int ay = a[1];
        int ar = a[2];
        
        int bx = b[0];
        int by = b[1];
        int br = b[2];
        
        
        double dis = Math.sqrt((ax-bx)*(ax-bx) + (ay-by)*(ay-by));
        
        return dis <=ar || dis<=br;
    }
    
    
    class UnionFind{
        
        int[] parent;
        int[] weight;
        int max = 1;
        
        public UnionFind(int n){
            
            parent = new int[n];
            weight = new int[n];
            
            for(int i=0; i<n; i++){
                parent[i] = i;
                weight[i] = 1;
            }
            
        }
        
        private int find(int x){
            
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }
        
        private void union(int a, int b){
            
            a = find(a);
            b = find(b);
            if(a==b)
                return ;
            
            if(weight[a]>=weight[b]){
                weight[a]+=weight[b];
                parent[b] = a;
                
                max = Math.max(max, weight[a]);
            }else{
                weight[b]+=weight[a];
                parent[a] = b;
                max = Math.max(max, weight[b]);
            }
            
        }
        
        
    }
}