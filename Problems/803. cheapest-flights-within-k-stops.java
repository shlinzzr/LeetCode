// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;
        
        
        int len = flights.length;
        
        
        for(; k>=0; k--){
            
            int[] temp = Arrays.copyOf(cost, n);
            
            for(int i=0; i<len; i++){
            
                int st = flights[i][0];
                int ed = flights[i][1];
                int p  = flights[i][2];

                if(cost[st]!=Integer.MAX_VALUE){
                    temp[ed] = Math.min(temp[ed], cost[st]+p);
                }
            }
            
            cost = temp;
        }
        
        
        
        
        
        return cost[dst]==Integer.MAX_VALUE? -1 : cost[dst];
    }
}