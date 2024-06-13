// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int M = edgeList.length, N = queries.length;
        
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < queries.length; i++) 
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i}; 
        
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        boolean[] res = new boolean[N];
        
        for (int i = 0, j = 0; i < N; i++) {
            int[] query = queries[i];
            while (j < edgeList.length && edgeList[j][2] < queries[i][2])
                uf.union(edgeList[j][0], edgeList[j++][1]);
            
            res[queries[i][3]] = uf.find(queries[i][0]) == uf.find(queries[i][1]);
        }
        return res;
    }
}

class UnionFind {
    int[] parent;
    public UnionFind(int N) {
        this.parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = parent[find(y)];
    }
}