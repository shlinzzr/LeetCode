// https://leetcode.com/problems/all-paths-from-source-to-target

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        int n = graph.length;
        
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        boolean[] seen = new boolean[n];
        seen[0] = true;
        dfs(0, graph, seen, curr, res);
        return res;
            
    }
    
    private void dfs(int node, int[][] graph, boolean[] seen, List<Integer> curr, List<List<Integer>> res){
        int n = seen.length;
        if(node==n-1){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int next : graph[node]){
            if(seen[next]) continue;
            seen[next] = true;
            curr.add(next);
            dfs(next, graph, seen, curr, res);
            curr.remove(curr.size()-1);
            seen[next] = false;
        }
        
        
    }
}