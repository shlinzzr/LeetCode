// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph

class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            map.put(i, i);
        }
        
        for(int[] eg : edges){ 
            int idx = find(eg[1], map);
            map.put(eg[0], idx);
        }
        
        HashMap<Integer, TreeSet<Integer>> unions = new HashMap<>();
        for(int[] eg : edges){
            int p = find(eg[0], map);
            
            if(!unions.containsKey(p)){
                unions.put(p, new TreeSet<>());
            }
            
            unions.get(p).add(eg[1]);
        }
        
        return unions.size();   
    }
    
    
    private int find(int s, HashMap<Integer, Integer> map){
        
        return map.get(s)==s ? s : find(map.get(s), map);
        
    }
}