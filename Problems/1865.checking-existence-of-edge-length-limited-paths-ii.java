// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths-ii

class DistanceLimitedPathsExist {

    TreeMap<Integer, int[]> map = new TreeMap<>();
    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        Arrays.sort(edgeList, (a,b)-> a[2]-b[2]);

        for(int[] e : edgeList){

            int a = e[0];
            int b = e[1];
            int d = e[2];
            union(a, b, parent);
            map.put(d, parent.clone());
        }



    }

    private void union(int a ,int b, int[] parent){

        a = find(a, parent);
        b = find(b, parent);
        if(a==b) return ;

        if(a<b){
            parent[b] = a;
        }else 
            parent[a] = b;
    }
        

    private int find(int x, int[] parent){
        if(parent[x]!=x) parent[x] = find(parent[x], parent);
        return parent[x];
    }   


    public boolean query(int p, int q, int limit) {

        Integer d = map.lowerKey(limit);
        if(d==null) return false;
        int[] parent = map.get(d);
        return find(p, parent)==find(q, parent);
    }
}

/**
 * Your DistanceLimitedPathsExist object will be instantiated and called as such:
 * DistanceLimitedPathsExist obj = new DistanceLimitedPathsExist(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */