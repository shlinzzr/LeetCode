// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    // dijkstra 
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->(a[2]-b[2])
        );
        
        int usedEdge = 0;
        while(k-->=0){
            
            int[] tmp = Arrays.copyOfRange(cost, 0, n);
            System.out.println(Arrays.toString(tmp));
            for(int i=0; i<n; i++){
                if(tmp[i]!=Integer.MAX_VALUE){
                    for(int[] f : flights){
                        
                        if(f[0]==i)
                            cost[f[1]] = Math.min(cost[f[1]], tmp[f[0]] + f[2]);
                    }
                }
            }
        }
        return cost[dst]==Integer.MAX_VALUE ? -1 : cost[dst];
        
    }
}