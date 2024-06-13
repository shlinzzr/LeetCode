// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;
        
        
        for(int i=0; i<=k; i++){
            
            int[] temp = Arrays.copyOf(cost, n);
            
            for(int j=0; j<flights.length; j++){
            
                int sc = flights[j][0];
                int dt = flights[j][1];
                int price = flights[j][2];
                
                if(cost[sc]!=Integer.MAX_VALUE){
                    temp[dt] = Math.min(temp[dt], cost[sc]+price);
                }                               
            }
            
            cost = temp;
            
        }
        
        
        return cost[dst];
        
        
        
        
    }
}