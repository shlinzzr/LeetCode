// https://leetcode.com/problems/bus-routes

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        // stop : routes
        
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
        
        
        boolean[] seen = new boolean[routes.length];
        int ans =1;
        Queue<Integer> queue = new LinkedList<>(); // route
        Set<Integer> routeSet = map.get(source);
        for(int s : routeSet){
            queue.add(s);    
            seen[s]=true;
        }
        
        while(!queue.isEmpty()){
            int siz = queue.size();
            for(int i=0; i<siz; i++){
                int routeIdx = queue.poll();    
                for(int busStop : routes[routeIdx]){
                    
                    if(busStop==target)
                        return ans;
                    
                    if(map.containsKey(busStop)){
                        routeSet = map.get(busStop);
                        for(int r : routeSet){
                            if(seen[r]==false)
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