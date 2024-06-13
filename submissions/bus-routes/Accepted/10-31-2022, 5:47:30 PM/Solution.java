// https://leetcode.com/problems/bus-routes

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        
        Map<Integer, List<Integer>> stopToBusMap=new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int stop: routes[i]){
                List<Integer> buses=stopToBusMap.computeIfAbsent(stop, t->new ArrayList<>());
                buses.add(i);
            }
            
        }
        
        if(!stopToBusMap.containsKey(source) || !stopToBusMap.containsKey(target)){
            return -1;
        }
        
        boolean[] visited=new boolean[routes.length];
        Queue<Integer> q=new LinkedList<>();
        int busCount=1;
        
        for(int boardingBus: stopToBusMap.get(source)){
            q.offer(boardingBus);
            visited[boardingBus]=true;
        }
        
        while(!q.isEmpty()){
            
            for(int x=q.size()-1;x>=0;x--){
                int currBus=q.poll();
                
                for(int stop: routes[currBus]){
                    if(!stopToBusMap.containsKey(stop)){
                        continue;
                    }
                    if(stop==target){
                        return busCount;
                    }
                    for(int boardingBus: stopToBusMap.get(stop)){
                        if(!visited[boardingBus]){
                            visited[boardingBus]=true;
                            q.offer(boardingBus);
                        }
                    }
                    
                }
            }
            
            busCount++;
        }
        return -1;
        
    }
}