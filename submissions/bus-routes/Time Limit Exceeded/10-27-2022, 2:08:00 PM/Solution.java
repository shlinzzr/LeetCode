// https://leetcode.com/problems/bus-routes

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();// busStop : routes
        
        if(source==target)
            return 0;
        
        // source =>. find target in route?
        // if not go another route
        
        for(int i=0; i<routes.length; i++){
            int[] r = routes[i];
            for(int busStop : r){
                Set<Integer> routeSet = map.getOrDefault(busStop, new HashSet<>());
                routeSet.add(i);
                map.put(busStop, routeSet);
            }
        }
        
        HashSet<Integer> seenStop = new HashSet<>();
        boolean[] seenRoute = new boolean[routes.length];
        int ans =1;
        Queue<Integer> queue = new LinkedList<>(); // route
        Set<Integer> routeSet = map.get(source);
        seenStop.add(source);
        for(int s : routeSet){
            queue.add(s);    
            seenRoute[s]=true;
        }
        
        while(!queue.isEmpty()){
            int siz = queue.size();
            for(int i=0; i<siz; i++){
                int routeIdx = queue.poll();    
                for(int busStop : routes[routeIdx]){
                    
                    if(seenStop.contains(busStop))
                        continue;
                    
                    seenStop.add(busStop);
                    if(busStop==target)
                        return ans;
                    
                    if(map.containsKey(busStop)){
                        routeSet = map.get(busStop);
                        for(int r : routeSet){
                            if(seenRoute[r]==false)
                                queue.add(r);
                        }
                    }
                }
            }
            ans++;
        }
        
        return -1;
        
    }
}