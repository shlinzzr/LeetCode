// https://leetcode.com/problems/cheapest-flights-within-k-stops

import java.util.Map; 
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

class Solution {
    
    //Bellman - Ford
    
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
   {
       int[] cost = new int[n];
       Arrays.fill(cost, Integer.MAX_VALUE);
       cost[src]=0;
       
       for(int i=0; i<=K; i++){
           
            int[] temp = Arrays.copyOf(cost,n);
            for(int[] f : flights){
                int curr=f[0], next=f[1], price=f[2];
                if(cost[curr]==Integer.MAX_VALUE)
                    continue; // 表示還沒飛到過
                
                temp[next] = Math.min(temp[next] , cost[curr]+f[2]);
            
            }
           cost = temp;
           
           
       }
       
       return cost[dst]==Integer.MAX_VALUE ? -1 : cost[dst];
       
       
   }
}