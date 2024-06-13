// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;

        while(k-->=0){
            
            int[] tmp = Arrays.copyOfRange(cost, 0, n);
            
            for(int i=0; i<flights.length; i++){
                int from = flights[i][0];
                int to   = flights[i][1];
                int price = flights[i][2];

                if(cost[from]!=Integer.MAX_VALUE){
                    tmp[to] = Math.min(tmp[to] ,  cost[from] + price);
                }
            }

            cost = tmp;
        }

        return cost[dst]==Integer.MAX_VALUE ? -1 : cost[dst];
    }
}