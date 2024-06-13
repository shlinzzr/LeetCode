// https://leetcode.com/problems/evaluate-division

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = queries.size();
        double[] res = new double[len];
        
        TreeMap<String, String> treeMap = new TreeMap<>();
        
        for(List<String> list : equations){
            treeMap.put(list.get(0), list.get(0));
            treeMap.put(list.get(1), list.get(1));
        }
        
        for(List<String> list : equations){
            String p = find(list.get(0), treeMap);
            treeMap.put(find(list.get(1), treeMap), p);
        }
        
         for(Map.Entry<String, String> en : treeMap.entrySet()){
            System.out.println(en.getKey()+ " "+ en.getValue());
        }
        
        
        
        
        HashMap<String, List<String>> unions = new HashMap<>();
        HashMap<String, List<Integer>> vals = new HashMap<>();
        
        for(List<String> list : equations){
            String p = find(list.get(0), treeMap);
            if(!unions.containsKey(p)) {
                unions.put(p, new ArrayList<>());
                vals.put(p, new ArrayList<>());
            }
            
            unions.get(p).add(list.get(1));
            vals.get(p).add()
            
            
        }
        
        for(Map.Entry<String, Set<String>> en : unions.entrySet()){
            System.out.println(en.getKey()+ " "+ en.getValue());
        }
        
        
        
        return res;
        
        
        
    }
    
    private String find(String s , TreeMap<String, String> map){
        return s.equals(map.get(s)) ? s : find(map.get(s), map); 
        
    }
}