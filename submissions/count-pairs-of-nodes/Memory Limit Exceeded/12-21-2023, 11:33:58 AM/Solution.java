// https://leetcode.com/problems/count-pairs-of-nodes

class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] res = new int[queries.length];

        int[][] grid = new int[n][n];

        for(int i=0; i<edges.length; i++){
            int[] e = edges[i];
            int u = e[0]-1;
            int v = e[1]-1;

            grid[u][v]++;
            grid[v][u]++;
        }

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]>0){
                    arr[i] += grid[i][j];
                }
            }

            // System.out.println(i+ " " + arr[i]);
        }

        for(int r=0; r<queries.length; r++){
            int q= queries[r];
            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    if(arr[i]+arr[j] - grid[i][j]>q){

                        
                        cnt++;
                    }
                }
            }

            res[r] = cnt;

        }

        return res;
    }
}