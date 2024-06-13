// https://leetcode.com/problems/is-graph-bipartite

class Solution {

    int[] parent;
    public boolean isBipartite(int[][] graph) {

        int len = graph.length;
        parent = new int[len];
        for(int i=0; i<len; i++){
            parent[i] = i;
        }

        for(int i=0; i<len; i++){
            int[] adjs = graph[i];

            if(adjs.length>0){
                int root = adjs[0];

                if(find(i)==find(root))
                    return false;

                for(int j=1; j<adjs.length; j++){
                    if(find(i)==find(adjs[j]))
                        return false;
                    union(root, adjs[j]);
                }
            }
        }

        return true;




        
    }

    private int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return;
        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
        
}