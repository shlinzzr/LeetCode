// https://leetcode.com/problems/count-pairs-of-nodes

class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] res = new int[queries.length];

        // int[][] grid = new int[n][n];
        HashMap<Integer, Map<Integer, Integer>> g = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int[] e = edges[i];
            int u = e[0]-1;
            int v = e[1]-1;

            g.putIfAbsent(u, new HashMap<>());
            g.putIfAbsent(v, new HashMap<>());

            g.get(u).put(v, g.get(u).getOrDefault(v, 0)+1);
            g.get(v).put(u, g.get(v).getOrDefault(u, 0)+1);

            // grid[u][v]++;
            // grid[v][u]++;
        }

        Element[] arr = new Element[n];
        for(int i=0; i<n; i++){

            Element el = new Element(i, 0);
            arr[i] = el;

            for(int j=0; j<n; j++){
                if(grid[i][j]>0){
                    arr[i].val += g.getOrDefault(u, new HashMap<>()).getOrDefault(v, 0);
                }
            }
            // System.out.println(i+ " " + arr[i]);
        }

        Arrays.sort(arr, (a,b)-> a.val-b.val);



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

    class Element{
        int idx;
        int val;
        public Element(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }

    private int getsum(int t, int n, int[][] grid){
        int cnt= 0;
        for(int int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]>0){
                    cnt+=grid[i][j];
                }
            }
        }

        return cnt;
    }
}