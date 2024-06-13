// https://leetcode.com/problems/reconstruct-itinerary

class Solution {

    List<String> res = new ArrayList<>();
    int ticketsCnt = 0;


    public List<String> findItinerary(List<List<String>> tickets) {

        ticketsCnt = tickets.size();

        Map<String, List<String>> graph = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new ArrayList<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        
        for(String k : graph.keySet()){
            Collections.sort(graph.get(k));
        }

        List<String> curr = new ArrayList<>();
        curr.add("JFK");
        HashSet<String> seen = new HashSet<>();
        dfs("JFK", graph, curr, seen);
        
        return res;
    }
    
    private void dfs(String airport, Map<String, List<String>> graph, List<String> curr, HashSet<String> seen) {

        if(curr.size()==ticketsCnt+1){
            res = new ArrayList<>(curr);
            return;
        }
            

        List<String> nextAirports = graph.getOrDefault(airport, new ArrayList<>());
       
        // while (nextAirports != null && !nextAirports.isEmpty()) {

            for(String next : nextAirports){
                if(!seen.contains(airport+"_"+next)){
                    seen.add(airport+"_"+next);
                    curr.add(next);
                    dfs(next, graph, curr, seen);
                    curr.remove(curr.size()-1);
                    seen.remove(airport+"_"+next);
                }
            }
        // }

        System.out.println("dfs " + airport);
        curr.add(airport);
    }
}