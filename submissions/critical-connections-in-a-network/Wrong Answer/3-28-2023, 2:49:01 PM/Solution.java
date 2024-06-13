// https://leetcode.com/problems/critical-connections-in-a-network

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Set<List<Integer>> res = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // HashMap<Integer, Integer>
            
            
        for(List<Integer> con : connections){
            
            map.putIfAbsent(con.get(0), new ArrayList<>());
            map.putIfAbsent(con.get(1), new ArrayList<>());
            map.get(con.get(0)).add(con.get(1));
            map.get(con.get(1)).add(con.get(0));
        }
        
        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
            
            if(en.getValue().size()==1){
                
                List<Integer> pair = new ArrayList<>();
                pair.add(en.getKey());
                
                int val = en.getValue().get(0);
                if(val>en.getKey())
                    pair.add(val);
                else 
                    pair.add(0, val);
                
                if(!res.contains(pair))
                    res.add(pair);
            }
        }
        
        return new ArrayList<>(res);
        
        
        
    }
}