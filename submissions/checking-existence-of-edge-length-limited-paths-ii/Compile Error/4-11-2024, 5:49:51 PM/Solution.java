// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths-ii

class DistanceLimitedPathsExist {

    int[][] g;

    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        g = new int[n][n];
        for(int[] a : g){
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        

        for(int[] e : edgeList){
            int a = e[0];
            int b = e[1];
            int d = e[2];

            if(g[a][b]>d){
                g[a][b] = d;
            }

            if(g[b][a]>d){
                g[b][a]=d;
            }
        }

        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                
            }
        }
            
    }
    
    public boolean query(int p, int q, int limit) {
        
    }
}

/**
 * Your DistanceLimitedPathsExist object will be instantiated and called as such:
 * DistanceLimitedPathsExist obj = new DistanceLimitedPathsExist(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */