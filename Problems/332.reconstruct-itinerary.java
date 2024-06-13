// https://leetcode.com/problems/reconstruct-itinerary

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for(List<String> t : tickets){
            map.putIfAbsent(t.get(0), new PriorityQueue<>());
            map.get(t.get(0)).offer(t.get(1));
        }
        List<String> res = new ArrayList<>();
        dfs("JFK", map, res);
        return res;
    }
    
    private void dfs(String curr, Map<String, PriorityQueue<String>> map , List<String> res ){
        PriorityQueue<String> pq = map.get(curr);
        
        while(pq!=null && !pq.isEmpty()){
            dfs(pq.poll(), map, res);
        }
        res.add(0, curr);
        
    }
}