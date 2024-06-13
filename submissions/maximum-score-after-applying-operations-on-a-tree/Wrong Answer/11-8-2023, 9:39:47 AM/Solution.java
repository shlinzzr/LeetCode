// https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree

class Solution {

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        HashMap<Integer, List<Integer>> g = new HashMap<>();

        int n = values.length;
        int len = edges.length;

        for(int i=0; i<len; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            g.putIfAbsent(u, new ArrayList<>());
            g.putIfAbsent(v, new ArrayList<>());
            g.get(u).add(v);
            g.get(v).add(u);
        }

        int total = 0;
        for(int v: values){
            total+=v;
        }

        int min = dfs(-1, 0, g, values);
        return total-min;

    }

    private int dfs(int parent, int node, HashMap<Integer, List<Integer>> g, int[] values){

        int sum = 0;
        for(int adj : g.get(node)){
            if(adj==parent)
                continue;

            sum += dfs(node, adj, g, values);
        }

        if(sum==0){
            return values[node];
        }

        return Math.min(values[node], sum);

    }
}