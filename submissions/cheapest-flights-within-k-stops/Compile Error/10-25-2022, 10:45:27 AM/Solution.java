// https://leetcode.com/problems/cheapest-flights-within-k-stops

import java.util.Map; 
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        HashMap<Integer, HashMap<Integer, Integer>> adj = new HashMap<>();
        
        for(int[] f : flights){
            int s = f[0];
            int d = f[1];
            int p = f[2];
            
            HashMap<Integer, Integer> map = adj.getOrDefault(s, new HashMap<Integer, Integer>());
            map.put(d, p);
            adj.put(s, map);
        }
        
        
        
        return dfs(adj, src, dst, k);
        
    }
    
    
    private int dfs(HashMap<Integer, HashMap<Integer, Integer>> adj, int src, int dst, int k){
        
        Queue<int[]> queue = new LinkedList<>();
        
        int[] srcEntry = new int[]{src, 0};
        // Map.Entry<Integer, Integer> srcEntry = new Map.Entry<Integer, Integer>(src, 0);
        queue.add(srcEntry);
        
        int min = Integer.MAX_VALUE;
        
        while(!queue.isEmpty() && k+1>0){
            int siz = queue.size();
            while(siz>0){
                
                int[] curr = queue.poll();
                int st = curr[0];
                int currPrice = curr[1];
                
                HashMap<Integer, Integer> adjMap = adj.get(st);
                if(adjMap!=null){
                    for(Map.Entry<Integer, Integer> en : adjMap.entrySet()){
                        
                        int ed = en.getKey();
                        int price = en.getValue();
                        if(ed==dst)
                            min = Math.min(min, price+currPrice);
                        
                        
                        if(price+currPrice>min || !map.containsKey(ed))
                            continue;
                        
                        int[] obj =  new int[]{ed, price+currPrice};
                        queue.offer(obj);
                    }                  
                    
                }
                
                siz--;
            }
            k--;
        }
        
         return min==Integer.MAX_VALUE? -1: min;
        
        
    }
}