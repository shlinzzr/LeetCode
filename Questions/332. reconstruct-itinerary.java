// https://leetcode.com/problems/reconstruct-itinerary

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        
        LinkedList<String> res = new LinkedList<>();
        
        dfs("JFK", graph, res);
        
        return res;
    }
    
    private void dfs(String curr, Map<String, PriorityQueue<String>> graph, LinkedList<String> res) {
        PriorityQueue<String> nextq = graph.get(curr);
        while (nextq != null && !nextq.isEmpty()) {
            dfs(nextq.poll(), graph, res);
        }
        res.addFirst(curr);
    }
}