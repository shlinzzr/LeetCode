// https://leetcode.com/problems/reconstruct-itinerary

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new ArrayList<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        
        for(String k : graph.keySet()){
            Collections.sort(map.get(k));
        }


        LinkedList<String> itinerary = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        dfs("JFK", graph, itinerary, seen);
        
        return itinerary;
    }
    
    private void dfs(String airport, Map<String, List<String>> graph, LinkedList<String> itinerary, HashSet<String> seen) {
        List<String> nextAirports = graph.getOrDefault(airport, new ArrayList<>());

       
        while (nextAirports != null && !nextAirports.isEmpty()) {

            for(String next : nextAirports){
                if(!seen.contains(airport+"_"+next)){
                    seen.add(airport+"_"+next);
                    dfs(next, graph, itinerary, seen);
                    seen.remove(airport+"_"+next);
                }
            }
        }
        itinerary.addFirst(airport);
    }
}