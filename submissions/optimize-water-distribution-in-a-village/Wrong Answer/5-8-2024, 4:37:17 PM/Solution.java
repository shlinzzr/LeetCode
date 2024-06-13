// https://leetcode.com/problems/optimize-water-distribution-in-a-village

class Solution {
    

    // Prim's
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        
        buildGraph(pipes, map);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1])); //idx, cost
        // Prim's algo : start from any node, let's say we start from node 1;
        // always choosing the min edge from map

        int min_well = Integer.MAX_VALUE;
        for(int w: wells){
            min_well = Math.min(min_well, w);
        }

        Set<Integer> seen = new HashSet<>();
        seen.add(1);
        Map<Integer, Integer> adjs = map.get(1);
        for(int adj : adjs.keySet()){
            pq.offer(new int[]{adj, adjs.get(adj)});
        }

        for(int[] a : pq){
            System.out.println(a[0] + " " + a[1]);
        }

        int currCost = 0;
        while(!pq.isEmpty()){
            int size =pq.size();
            while(size-->0){

                int[] p = pq.poll();
                int idx = p[0];
                int pipeCost = p[1];

                if(seen.contains(idx)) continue;
                seen.add(idx);
                currCost += pipeCost;

                adjs = map.get(idx);
                for(int k : adjs.keySet()){
                    if(seen.contains(k)) continue;
                    pq.offer(new int[]{k, adjs.get(k)});
                }

                System.out.println(idx+ " pc="+pipeCost);
            }

            System.out.println(pq.size());
        }

        System.out.println(currCost +" " + min_well);

        return currCost + min_well;

    }


    private void buildGraph(int[][] pipes, Map<Integer, Map<Integer,Integer>> map ){

        for(int[] p : pipes){
            int a = p[0];
            int b = p[1];
            int c = p[2];

            map.putIfAbsent(a, new HashMap<>());
            if(!map.get(a).containsKey(b) || map.get(a).get(b)>c)
                map.get(a).put(b, c);

            map.putIfAbsent(b, new HashMap<>());
            if(!map.get(b).containsKey(a) || map.get(b).get(a)>c)
                map.get(b).put(a, c);
        }

    }
}