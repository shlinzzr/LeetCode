// https://leetcode.com/problems/all-paths-from-source-to-target

class Solution {
    
    List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        
        List<Integer> curr= new ArrayList<>();
        curr.add(0);
        helper(graph, 0, curr);
        return list;
    }
    
    
    private void helper(int[][] graph, int idx, List<Integer> curr){
        
        
        if(idx == graph.length-1)
            list.add(curr);
        
        
        
        for(int i :graph[idx]){
            ArrayList<Integer> newList = new ArrayList<>(curr);
            newList.add(i);
            helper(graph, i, newList);
        }
        
        
        
    }
}