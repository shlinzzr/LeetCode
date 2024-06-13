// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<String, Integer> price = new HashMap<>();
        
        for(int[] f: flights){
            int st = f[0];
            int ed = f[1];
            int p = f[2];
            
            map.putIfAbsent(st, new ArrayList<>());
            map.get(st).add(ed);
            price.put(st+"->"+ed, p);
        }
        
        
            
            
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        cost[src]=0;
        
        
        while(!q.isEmpty() && k>=0){
            
            System.out.println("k="+k);
            
            for(int i=q.size(); i>0; i--){
                int[] po = q.poll();
                int st   = po[0];
                int base = po[1];
                
                for(int next : map.getOrDefault(st, new ArrayList<>())){
                    
                    
                    
                    int p = price.get(st+"->"+next);
                    
                    // System.out.println(st+"->"+next + " =" + p);
                    
                    if(p+base<cost[next]){
                        cost[next] = p+base;
                    }
                    
                    q.offer(new int[]{next, cost[next]});
                }
            }
            
            k--;
        }
        
        return cost[dst]==Integer.MAX_VALUE? -1 : cost[dst];
    }
}