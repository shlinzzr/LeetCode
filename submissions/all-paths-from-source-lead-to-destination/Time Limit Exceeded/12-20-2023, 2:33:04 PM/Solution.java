// https://leetcode.com/problems/all-paths-from-source-lead-to-destination

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        int destOut= 0;
        for(int[] e: edges){
            g.putIfAbsent(e[0], new ArrayList<>());
            g.get(e[0]).add(e[1]);
            if(e[0]==destination)       
                destOut++;
        }

        if(destOut!=0) return false;
        return helper(g, source, destination,  new HashSet<>());

    }


    // private boolean helper(int node, int destination, Map<Integer, List<Integer>> graph, Set<Integer> seen){
    //     if(!graph.containsKey(node) && node == destination) return true;  
    //     if(!graph.containsKey(node) || seen.contains(node)) return false;
        
    //     for(int child : graph.get(node)){   
    //         seen.add(node);
    //         if(!helper(child, destination, graph, seen))
    //             return false;
    //         seen.remove(node);
    //     }
    //     return true;
    // }


    private boolean helper(HashMap<Integer, List<Integer>> g , int cur, int tar, HashSet<Integer> seen){
        if(cur==tar && g.getOrDefault(cur, new ArrayList<>()).isEmpty()) return true;

        if(seen.contains(cur) || g.getOrDefault(cur, new ArrayList<>()).isEmpty()) return false;

        for(int next : g.get(cur)){
            seen.add(cur);
            boolean rt = helper(g, next, tar, seen);
            if(rt==false) return false;
            seen.remove(cur);
        }

        return true;


    }
}