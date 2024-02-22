// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies

class Solution {
    //  O(V + E) == O(recipes.length + supplies.length + sum(ingredients[i].size)) time and space.
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
         // Recipes and supplies are nodes in the graph. The ingredients list gives us the edges.
        Map<String, List<String>> graph = new HashMap<>();  
        Map<String, Integer> inDegree = new HashMap<>();  
        Set<String> recipesSet = new HashSet<>();   // for answer need
        
        // Add supply nodes to the graph. (no need)
        for (String sup : supplies) {
            // graph.put(sup, new ArrayList<>());
            inDegree.put(sup, 0);
        }
        
        // Add recipe nodes to the graph. (no need)
        for (String rcp : recipes) {
            // graph.put(rcp, new ArrayList<>());
            // inDegree.put(rcp, 0);
            recipesSet.add(rcp);  // for answer need
        }
        
        // Add edges to the graph.
        for (int i = 0; i < ingredients.size(); ++i) {
            for (String ing : ingredients.get(i)) {
                graph.putIfAbsent(ing, new ArrayList<>());   
                graph.get(ing).add(recipes[i]); 
            }
            inDegree.put(recipes[i], ingredients.get(i).size());   
        }
        
        // Standard topological sort
        List<String> result = new ArrayList<>();
        Deque<String> queue = new ArrayDeque<>();
        
        for (String currNode : inDegree.keySet()) {
            if (inDegree.get(currNode) == 0) 
                queue.offer(currNode);
        }
        
        while (queue.size() > 0) {
            String p = queue.poll();

            if (recipesSet.contains(p)) {
                result.add(p);
            }
            for (String adj : graph.getOrDefault(p, new ArrayList<>())) {
                inDegree.put(adj, inDegree.get(adj) - 1);
                if (inDegree.get(adj) == 0) 
                    queue.offer(adj);
            }
        }
        return result;
    }
}