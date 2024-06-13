// https://leetcode.com/problems/modify-graph-edge-weights

class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int src, int dest, int target) {
        
        int[][] g = new int[n][n];
        for(int i=0; i<n;i++){
            Arrays.fill(g[i], Integer.MAX_VALUE);
            g[i][i]=0;
        }

        Set<int[]> set = new HashSet<>();
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            int w = e[2];
            if(w!=-1){
                g[a][b]=Math.min(g[a][b], w);
                g[b][a]=Math.min(g[b][a], w);
            }
            // set.add(new int[]{a,b});
            // set.add(new int[]{b,a});
        }

        // int[] distTo = new int[n];
        // distTo[src]=0;

        // Queue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        // pq.add(new int[] {src, 0});

        // while(!pq.isEmpty()){
        //     int[] cur = pq.poll();

        // }


        List<int[]> list = new ArrayList<>();
        for(int k=0;k<n; k++){
            for(int i=0; i<n;i++){
                if(g[i][k]<Integer.MAX_VALUE){
                    for(int j=0; j<n; j++){
                        if(g[k][j]<Integer.MAX_VALUE){
                            g[i][j]=Math.min(g[i][j], g[i][k]+g[k][j]);
                            list.add(new int[]{i, j, g[i][j]});
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
            
        }



        for(int[] p : set){

            int a = p[0];
            int b = p[1];

            if(g[a][b]==Integer.MAX_VALUE) 

                if(g[src][a]<Integer.MAX_VALUE && g[b][dest]<Integer.MAX_VALUE && g[src][a]+g[b][dest]<target){
                g[a][b] = target - g[src][a] - g[b][dest];
                list.add(new int[]{a,b,g[a][b]});
            }



             if(g[b][a]==Integer.MAX_VALUE) 

                if(g[src][b]<Integer.MAX_VALUE && g[a][dest]<Integer.MAX_VALUE && g[src][b]+g[a][dest]<target){
                g[b][a] = target - g[src][b] - g[a][dest];
                list.add(new int[]{b,a,g[b][a]});
            }
        }

        int[][] res= new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }



        return res;



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