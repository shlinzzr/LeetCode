// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {

    // dijkstra : 只能拿來找 shortest path
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        buildMap(flights, map);

        // System.out.println(map);

        Set<Integer> seen = new HashSet<>();
        seen.add(src);
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> a[2]-b[2]
        );

        for(int adj : map.getOrDefault(src, new HashMap<>()).keySet()){
            pq.offer(new int[]{src, adj, map.get(src).get(adj)});
        }

        int edgeCnt = 0;

        System.out.println("pq.size()="+pq.size());

        while(edgeCnt<=k+1 && !pq.isEmpty()){

            int[] p = pq.poll();

            System.out.println(p[0] + " " + p[1] + " " + p[2]);

            if(seen.contains(p[1])) continue;

            seen.add(p[1]);
            cost[p[1]] = cost[p[0]] + p[2];
            edgeCnt++;

            if(p[0]==dst) return cost[dst];

            for(int key : map.getOrDefault(p[1], new HashMap<>()).keySet()){
                if(seen.contains(key)) continue;
                pq.offer(new int[]{p[1], key, map.get(p[1]).get(key)});
            }
        }
        return -1;

    }


    private void buildMap(int[][] flights, Map<Integer, Map<Integer, Integer>> map){
        
        for(int[] f : flights){
            map.putIfAbsent(f[0], new HashMap<>());
            
            if(!map.get(f[0]).containsKey(f[1]) || map.get(f[0]).get(f[1])>f[2]){
                map.get(f[0]).put(f[1], f[2]);
            }
        }
    }


    // Bellmen-ford 
    // public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
    //     int[] cost = new int[n];
    //     Arrays.fill(cost, Integer.MAX_VALUE);
    //     cost[src] = 0;
        
    //     PriorityQueue<int[]> pq = new PriorityQueue<>(
    //         (a,b)->(a[2]-b[2])
    //     );
        
    //     while(k-->=0){
    //         int[] tmp = Arrays.copyOfRange(cost, 0, n);
    //         for(int i=0; i<n; i++){
    //             if(tmp[i]!=Integer.MAX_VALUE){
    //                 for(int[] f : flights){
    //                     if(f[0]==i)
    //                         cost[f[1]] = Math.min(cost[f[1]], tmp[f[0]] + f[2]);
    //                 }
    //             }
    //         }
    //     }
    //     return cost[dst]==Integer.MAX_VALUE ? -1 : cost[dst];
        
    // }
}