// https://leetcode.com/problems/all-paths-from-source-to-target

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        helper(graph, res, curr, graph[0]);
        
        
        return res;
        
    }
    
    private void helper(int[][] graph,  List<List<Integer>> res, List<Integer> curr, int[] tar){
        
        if(tar.length==0){
            if(curr.get(curr.size()-1)==graph.length-1)
                res.add(new ArrayList<>(curr));
            return;
        }
        
        
        for(int dst : tar){
            curr.add(dst);
            helper(graph, res, curr, graph[dst]);
            curr.remove(curr.size()-1);
        }
        
        
        
        
    }
}