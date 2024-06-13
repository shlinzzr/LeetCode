// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        int len = flights.length;

        while(k-->=0){

            int[] tmp = Arrays.copyOf(cost, n);

            for(int[] f: flights){
                int from = f[0];
                int to = f[1];
                int price = f[2];

                if(tmp[from]!=Integer.MAX_VALUE){
                    cost[to] = Math.min(cost[to], tmp[from]+price);
                }
            }
        }

        return cost[dst]==Integer.MAX_VALUE ? -1 : cost[dst];
        
    }
}