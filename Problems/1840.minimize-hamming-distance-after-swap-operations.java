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

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res= 0 ;

        for(int i=0; i<len; i++){
            int idx = find(i);
            int val = source[i];
            Map<Integer, Integer> sub = map.getOrDefault(idx, new HashMap<>());
            sub.put(source[i], sub.getOrDefault(source[i],0)+1);
            map.put(idx, sub);
        }

        for(int i=0; i<len; i++){
            int idx = find(i);
            Map<Integer, Integer> sub = map.getOrDefault(idx, new HashMap<>());
            int val = target[i];

            if(!sub.containsKey(val)){
                res++;
            }else{
                sub.put(val, sub.get(val)-1);
                if(sub.get(val)==0)
                    sub.remove(val);
            }
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