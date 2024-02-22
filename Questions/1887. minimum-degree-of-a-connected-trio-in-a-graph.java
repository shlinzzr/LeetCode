// https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph

class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int[][] grid = new int[n][n];

        for(int i=0; i<edges.length; i++){
            int[] e = edges[i];
            int u = e[0]-1;
            int v = e[1]-1;

            grid[u][v] = 1;
            grid[v][u] = 1;
        }

        int[] cnt = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1)
                    cnt[i]++;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){

                    if(grid[i][j]==1 && grid[j][k]== 1 && grid[i][k]==1){
                        min = Math.min(min, cnt[i]-2 + cnt[j]-2 + cnt[k]-2);
                    }

                }
            }
        }

        return min==Integer.MAX_VALUE? -1 : min;
    }
}