// https://leetcode.com/problems/bus-routes

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if(source==target)
            return 0;
        
        int rLen = routes.length;
        
        HashMap<Integer, Set<Integer>> rMap = new HashMap<>(); // routeId, set<busStop>
        for(int i=0; i<rLen; i++){
            rMap.put(i, new HashSet<>());
            for(int b:routes[i])  
                rMap.get(i).add(b);
        }
        
        HashMap<Integer, Set<Integer>> bMap = new HashMap<>(); // busStop, set<routeId> 
        for(int i=0; i<rLen; i++){
            
            int[] busStops = routes[i];
            
            for(int b : busStops){
                bMap.putIfAbsent(b, new HashSet<>());
                bMap.get(b).add(i);
            }
        }
        
        
        boolean[] token = new boolean[rLen];
        Queue<Integer> q = new LinkedList<>(); // busStop
        q.add(source);
        
        Set<Integer> srcRoutes = bMap.get(source);
        for(int s: srcRoutes){
            // token[s]=true;
            
            Set<Integer> bset = rMap.get(s);
            if(bset.contains(target))
                return 1;
            
        }
        
        
        
        
        int cnt = 1;
        
        while(!q.isEmpty()){
            
            for(int i=q.size(); i>0; i--){
                
                int busStop = q.poll();
                
                Set<Integer> rset = bMap.get(busStop);
                if(rset==null || rset.isEmpty())
                    continue;
                
                // System.out.println(busStop + " " + rset.toString());
                
                for(int r : rset){
                    
                    if(token[r])
                        continue;
                    token[r]=true;
                    
                    Set<Integer> bset = rMap.get(r);
                    
                    if(bset.contains(target))
                        return cnt;
                    
                    for(int b: bset){
                        q.offer(b);
                        // System.out.println(cnt + " " + busStop + "->" +b);
                    }
                }
            }
            
            cnt++;
            
        }
        
        return -1;
        
    }
}