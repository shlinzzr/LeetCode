// https://leetcode.com/problems/bus-routes

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if(source==target) return 0;

        int len = routes.length;

        Map<Integer, List<Integer>> map = new HashMap<>(); // bus_stop_id, r_id, 

        int targetBus = -1;

        for(int i=0; i<routes.length;i++){
            int[] r = routes[i];
            for(int stop : r){
                map.putIfAbsent(stop, new ArrayList<>());
                map.get(stop).add(i);
            }
        }

        

        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);

        int step = 1;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int stop_id = q.poll();

                for(int r_id : map.getOrDefault(stop_id, new ArrayList<>())){

                    if(seen.add(r_id)==false) continue;

                    for(int nextStop : routes[r_id]){

                        if(nextStop==target) return step;
                        q.offer(nextStop);
                    }
                }
                
            }
            step++;
        }
        return -1;
        
    }
}