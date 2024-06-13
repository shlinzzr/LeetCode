// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    // dijkstra 
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        
        
        while(k-->=0){
            int[] tmp = Arrays.copyOfRange(cost, 0, n);
            
            for(int[] f : flights){
                if(tmp[f[0]]!=Integer.MAX_VALUE){
                    cost[f[1]] = Math.min(cost[f[1]], tmp[f[0]] + f[2]);
                }
            }
        }
        return cost[dst]==Integer.MAX_VALUE ? -1 : cost[dst];
        
    }
}