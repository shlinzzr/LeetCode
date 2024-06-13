// https://leetcode.com/problems/minimum-height-trees

class Solution {
    int min = Integer.MAX_VALUE;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         List<Integer> res = new ArrayList<>();
        
        if(n==1){
            res.add(0);
            return res;
        }
            
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        for(int[] e  : edges){
            
            HashSet<Integer> set1 = map.getOrDefault(e[0], new HashSet<>());
            set1.add(e[1]);
            HashSet<Integer> set2 = map.getOrDefault(e[1], new HashSet<>());
            set2.add(e[0]);
            map.put(e[0], set1);
            map.put(e[1], set2);
        }
        
        // Queue<Integer> q = new LinkedList<>();
        // XX... USE BFS WILL TLE 
        
        // Sol 2:  remove from leaf;
        List<Integer> leaves = new ArrayList<>();
        for(Map.Entry<Integer, HashSet<Integer>> en : map.entrySet()){
            if(en.getValue().size()==1){
                leaves.add(en.getKey());
            }
        }
        
        while(n>2){  //if node==1 or 2 the answer is the leaves
            
            n-=leaves.size();
            
            List<Integer> newLeaves = new ArrayList<>();
            
            for(int leaf : leaves){
                int adj = map.get(leaf).iterator().next();
                map.get(adj).remove(leaf);
                if(map.get(adj).size()==1)
                    newLeaves.add(adj);
            }
            leaves=newLeaves;
        }
        
        return leaves;
        
    }
}