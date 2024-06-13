// https://leetcode.com/problems/number-of-operations-to-make-network-connected

class Solution {

    int[] parent;
    public int makeConnected(int n, int[][] connections) {

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        int cnt = 1;
        int op = 0;
        for(int[] con : connections){
            int a = con[0];
            int b = con[1];
            if(union(a,b)) cnt++;
            else op++;
        }
        return op+cnt>=n ? n-cnt : -1;
        
    }
    private boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return false;

        if(a<b) parent[b] = a;
        else parent[a] =b;
        return true;
    }

    private int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }
}