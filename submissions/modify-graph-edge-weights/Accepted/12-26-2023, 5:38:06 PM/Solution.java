// https://leetcode.com/problems/modify-graph-edge-weights

class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int src, int dest, int target) {
        
        int[][] g = new int[n][n];
        for(int i=0; i<n;i++){
            Arrays.fill(g[i], Integer.MAX_VALUE/2);
            g[i][i]=0;
        }

        for(int[] e : edges){

            if(e[2]==-1) continue;

            int a = e[0];
            int b = e[1];
            int w = e[2];
            g[a][b]=Math.min(g[a][b], w);
            g[b][a]=Math.min(g[b][a], w);
        }

        for(int k=0;k<n; k++){
            for(int i=0; i<n;i++){
                if(g[i][k]<Integer.MAX_VALUE/2){
                    for(int j=0; j<n; j++){
                        if(g[k][j]<Integer.MAX_VALUE/2){
                            g[i][j]=Math.min(g[i][j], g[i][k]+g[k][j]);
                        }
                    }
                }
            }
        }

        if(g[src][dest]==target){
            return fill(edges);

        }else if(g[src][dest]<target)
            return new int[0][0];

        else{
            for (int[] e : edges) {
                if (e[2] == -1) {
                    e[2] = 1;
                    int a = e[0];
                    int b = e[1];

                    g[a][b] = 1;
                    g[b][a] = 1;
                    for(int i=0; i<n; i++){
                        for(int j=0; j<n; j++){
                            if(g[i][a]<Integer.MAX_VALUE/2 && g[b][j]<Integer.MAX_VALUE/2){
                                g[i][j] = Math.min(g[i][j], g[i][a]+ e[2] +g[b][j] );
                            }

                            if(g[i][b]<Integer.MAX_VALUE/2 && g[a][j]<Integer.MAX_VALUE/2){
                                g[i][j] = Math.min(g[i][j], g[i][b]+ e[2] +g[a][j] );
                            }
                        }
                    }
                    if(g[src][dest]==target){
                        return fill(edges);

                    }else if(g[src][dest]<target){
                        e[2] +=target-g[src][dest];
                        // g[a][b] = e[2];
                        // g[b][a] = e[2];
                        return fill(edges);
                    }
                
                }
            }
        }
        System.out.println("hello");
         return new int[0][0];

    }

    private int[][] fill(int[][] edges) {
        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = (int) (2 * 1e9);
            }
        }
        return edges;
    }
}