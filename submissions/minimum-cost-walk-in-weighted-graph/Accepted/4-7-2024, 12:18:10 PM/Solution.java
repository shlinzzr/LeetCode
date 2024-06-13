// https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph

class DSU {
    int[] parent, rank, weights;
    public DSU(int n) {
        parent = new int[n];
        // rank = new int[n];
        weights = new int[n];
        Arrays.fill(weights, 131071);
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }
    public int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y, int weight) {
        x = find(x);
        y = find(y);

        if(x<y)
            parent[y]=x;
        else 
            parent[x]=y;
        // i1f (rank[xx] < rank[yy])
        //     parent[xx] = yy;
        // else
        //     parent[yy] = xx;
        weights[x] = weights[y] = weights[x] & weights[y] & weight;


        // if (rank[xx] == rank[yy])
        //     rank[xx]++;
    }
    public int minimum_cost_of_walk(int x, int y) {
        if (x == y)
            return 0;
        if (find(x) != find(y))
            return -1;
        return weights[find(x)];
    }
}
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU uf = new DSU(n);
        for (int[] edge : edges)
            uf.union(edge[0], edge[1], edge[2]);
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++)
            result[i] = uf.minimum_cost_of_walk(query[i][0], query[i][1]);
        return result;
    }
}