// https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations

class Solution {
    int[] parent;
    public int minimumHammingDistance(int[] source, int[] target, int[][] swap) {
        int len = source.length;

        parent = new int[len];
        for(int i=0; i<len ; i++){
            parent[i] = i;
        }

        for(int[] s : swap){
            int a = s[0];
            int b = s[1];

            union(a, b);
        }


        int res= 0 ;
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<len; i++){
            int idx = find(i);
            map.putIfAbsent(idx, new HashSet<>());
            map.get(idx).add(source[i]);
        }

        for(int i=0; i<len; i++){
            int idx= find(i);
            if(!map.getOrDefault(idx, new HashSet<>()).contains(target[i]))
                res++;
        }

        return res;
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return ;
        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    private int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }
}