// https://leetcode.com/problems/all-paths-from-source-to-target

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res= new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        list.add(0);
        helper(graph, list, 0, res);
        
        return res;
    }
    
    
    private void helper(int[][] graph, List<Integer> list, int curr, List<List<Integer>> res){
        
        if(graph[curr].length==0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int next : graph[curr]){
            list.add(next);
            helper(graph, list, next, res);
            list.remove(list.size()-1);
        }
    }
    
    
}