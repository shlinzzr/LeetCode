// https://leetcode.com/problems/minimum-height-trees

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if (n == 1) return Collections.singletonList(0);
        
        List<Set<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n;i++) 
            adjList.add(new HashSet<>());
        
        for(int[] arr:edges){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<adjList.size(); i++){
            Set<Integer> set =adjList.get(i);
            if(set.size()==1){
                leaves.add(i);
            }
        }
        
        
        while(n>2){
            n-=leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves){
                
                int adj = adjList.get(leaf).iterator().next();
                adjList.get(adj).remove(leaf);
                if (adjList.get(adj).size() == 1) 
                    newLeaves.add(adj);
                
                
                
//                 for(int i=0; i<adjList.size(); i++){
//                     Set<Integer> set =adjList.get(i);
                    
//                     if(i==leaf)
//                         set.clear(); 
                    
//                     if(set.contains(leaf))
//                         set.remove(leaf);
                    
//                     if(set.size()==1)
//                         newLeaves.add(i);
//                 }
                leaves = newLeaves;
            }
        }
        
        
        return leaves;
        
        
         
        
    }
}