// https://leetcode.com/problems/course-schedule-iv

class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        // List<Boolean>  res= new ArrayList<>();

        // List<Integer>[] adj = new ArrayList[n];
        // for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        // int[] indeg = new int[n];

        // for(int[] p : pre){
        //     indeg[p[1]]++;
        //     adj[p[0]].add(p[1]);
        // }

        // Floy-warshall problems:
        boolean[][] connected = new boolean[n][n];
        for (int[] p : prerequisites)
            connected[p[0]][p[1]] = true; // p[0] -> p[1]
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    connected[i][j] = connected[i][j] || connected[i][k] && connected[k][j];
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries)
            ans.add(connected[q[0]][q[1]]);
        return ans;

    }
}