// https://leetcode.com/problems/design-graph-with-shortest-path-calculator

class Graph {
    int[][] g ;
    int n; 
    final int MAX_VALUE = 500_000_000;
    public Graph(int n, int[][] edges) {
        g = new int[n][n];
        this.n = n;
        for(int i=0; i<n; i++){
            Arrays.fill(g[i], MAX_VALUE);
            g[i][i] = 0;
        }

        for(int[] e : edges){
            g[e[0]][e[1]] = e[2];
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                if(g[i][k]==MAX_VALUE) continue;
                for(int j=0; j<n; j++){

                    if(g[k][j]==MAX_VALUE) continue;
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {

        int a = edge[0];
        int b = edge[1];
        int distance = edge[2];

        if(g[a][b]<= distance) return;

        g[a][b] = distance;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                g[i][j] = Math.min(g[i][j], g[i][a] + distance + g[b][j]);
            }
        }
    }


    
    public int shortestPath(int node1, int node2) {
        return g[node1][node2]==MAX_VALUE ? -1 : g[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */