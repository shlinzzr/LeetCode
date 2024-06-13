// https://leetcode.com/problems/detonate-the-maximum-bombs

class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        /*
        
        https://leetcode.com/problems/detonate-the-maximum-bombs/discuss/1625917/Union-Find-146-160-test-cases-passed.-Why
        
        [[1,1,5], [5,1,1], [9,1,5]]
        
        The problem is directed, where union find does not work.
        For example, first bomb at [1,1,5], 2nd at [5,1,1], and 3rd at [9,1,5]. Running union-find over bomb 1, it can reach 2, so 1 and 2 are unioned. Bomb 2 cannot reach any other two, no change. For bomb 3, it can detonate bomb 2, therefore, it will be unioned with 2 and 1, i.e. all three bombs unioned. However, in reality, since bomb 2 has only a radius of 1, detonation stops after bomb 2, and the correct maximum should be 2 instead of 3.
*/
        
        int len = bombs.length;
        
        UnionFind uf = new UnionFind(len);a
        
        for(int i=0; i<len; i++){
            
            for(int j=0; j<len; j++){
                
                int[] a = bombs[i];
                int[] b = bombs[j];
                
                boolean ir = inRange(a, b);
                
                if(ir){
                    uf.union(i, j);
                }
            }
        }
        
//         for(int i=0; i<len; i++){
//             System.out.println("i="+i + " " + uf.parent[i] + " " + uf.weight[i] );
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
        
        return dis <=ar ;
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
                max = Math.max(max, weight[b] );
            }
            
        }
        
        
    }
}