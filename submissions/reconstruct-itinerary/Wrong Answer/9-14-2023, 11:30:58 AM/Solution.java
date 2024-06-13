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
        // System.out.println(airport + " next=" + graph.get(airport) + " curr=" + curr + " seen=" + seen);
        if(curr.size()==ticketsCnt+1){
            res = new ArrayList<>(curr);
            return;
        }
            

        List<String> nextAirports = graph.get(airport);
        if(nextAirports==null)
            return;
       

        for(String next : nextAirports){
            if(!seen.contains(airport+"->"+next)){
                seen.add(airport+"->"+next);
                curr.add(next);
                dfs(next, graph, curr, seen);
                if(res.size()>0)
                    return;
                curr.remove(curr.size()-1);
                seen.remove(airport+"->"+next);
            }
        }

    }
}