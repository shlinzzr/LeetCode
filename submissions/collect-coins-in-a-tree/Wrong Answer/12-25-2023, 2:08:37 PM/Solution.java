// https://leetcode.com/problems/collect-coins-in-a-tree

class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        HashMap<Integer, Integer> indeg = new HashMap<>();
        for(int[] e : edges){
            indeg.put(e[0], indeg.getOrDefault(e[0], 0)+1);
            indeg.put(e[1], indeg.getOrDefault(e[1], 0)+1);
            g.putIfAbsent(e[0], new ArrayList<>());
            g.putIfAbsent(e[1], new ArrayList<>());
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> en : indeg.entrySet()){
            if(en.getValue()==1){
                q.offer(en.getKey());
            }
        }
        int k = 1;
        while(!q.isEmpty() && k-->0){
            int siz = q.size();
            for(int i=0; i<siz; i++){
                int p = q.poll();
                for(int next : g.getOrDefault(p, new ArrayList<>())){
                    indeg.remove(next);
                }
                indeg.remove(p);
            }
        }

        int nodeCnt = indeg.keySet().size();
        int edgeCnt = nodeCnt-1;
        return 2*edgeCnt;

    }
}