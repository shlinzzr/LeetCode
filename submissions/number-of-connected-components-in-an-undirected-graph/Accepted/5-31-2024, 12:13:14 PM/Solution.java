// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph

class Solution {

    int[] parent;
    public int countComponents(int n, int[][] edges) {

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(int[] e: edges){
            union(e[0], e[1]);
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            if(parent[i] ==i) cnt++;
        }

        return cnt;


    }

    private int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return;

        if(a<b){
            parent[b] = a;
        }else
            parent[a] = b;
    }
}