// https://leetcode.com/problems/number-of-possible-sets-of-closing-branches

class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        HashMap<Integer, Map<Integer, Integer>> g = new HashMap<>();
        buildMap(g, roads);
        
        List<List<Integer>> res = new ArrayList<>();
        helper(g, res, new ArrayList<>(), n, maxDistance, 0);
        System.out.println(res);
        return res.size();
    }

    
    private void helper(HashMap<Integer, Map<Integer, Integer>> g,  List<List<Integer>> res, List<Integer> curr, int n, int md , int st){
          res.add(new ArrayList<>(curr));
        // System.out.println("helper="+curr  );
        if(st==n){
          
            return;
        }
        
        
        for(int node=st; node<n; node++){
            
            Map<Integer, Integer> adj = g.getOrDefault(node, new HashMap<>());
            boolean cantake =true;
            for(Map.Entry<Integer,Integer>en : adj.entrySet()){
                
                // System.out.println("node="+node + " k="+en.getKey() + " v="+en.getValue() );
                if(en.getValue()>md && en.getKey()<node && curr.contains(en.getKey())){
                    cantake=false;
                    break;
                }
            }
                   
            if(cantake){
                curr.add(node);
                helper(g, res, curr, n, md, node+1);
                curr.remove(curr.size()-1);
            }
            
        }
    }
    
    
    private void buildMap(HashMap<Integer, Map<Integer, Integer>> g, int[][] roads){
        
        
        for(int[] r: roads){
            int u = r[0];
            int v = r[1];
            int d = r[2];
            
            g.putIfAbsent(u, new HashMap<Integer, Integer>());
            g.get(u).put(v, d);
            
            g.putIfAbsent(v, new HashMap<Integer, Integer>());
            g.get(v).put(u, d);
            
        }
    }
    
    
}