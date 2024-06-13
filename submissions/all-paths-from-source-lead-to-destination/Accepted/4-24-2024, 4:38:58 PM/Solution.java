// https://leetcode.com/problems/all-paths-from-source-lead-to-destination

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Boolean> memo = new HashMap<>();
        
        for(int i=0; i< edges.length; i++){
            int src = edges[i][0];
            int tar = edges[i][1];

            graph.putIfAbsent(src, new ArrayList<>());
            graph.get(src).add(tar);   
        }
        
        boolean result = dfs(graph, memo, source, destination);
        
        return result;

    }
    
    
    public boolean dfs(Map<Integer, List<Integer>> graph,  Map<Integer, Boolean> memo, int curr, int destination ){
        
        if(memo.containsKey(curr))
            return memo.get(curr);
    
        // to check the below condition 
        // node with no outgoing edges should be equal to destination
        
        if(curr == destination && graph.get(destination) ==null)
            return true;
        
         if(curr == destination && graph.get(destination).size() > 0)
            return false;
        
        
        // if any node has no outgoing edges and it is not destination then return false'
         if(curr != destination && graph.get(curr) ==null)
            return false;
        
       
        
        memo.put(curr, false);
        
        for(int next:  graph.getOrDefault(curr, new ArrayList<>())){
            
            boolean result = dfs(graph, memo, next, destination);
            
            if(result==false)
                return false;
        }
        
        memo.put(curr, true);
        
        return true;
        
    }
}