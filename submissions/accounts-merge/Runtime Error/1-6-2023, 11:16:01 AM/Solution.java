// https://leetcode.com/problems/accounts-merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
     
        
        HashMap<String, String> parentMap = new HashMap<>(); // email, parent
        HashMap<String, String> userMap = new HashMap<>(); // email, user
        
        
       for (List<String> list : accounts) {
            String user = list.get(0);
            for(int i=1; i<list.size();i++){
                userMap.put(list.get(i), user);
                parentMap.put(list.get(i), list.get(i)); //initialize : parent is self
            }
        }

        // union find
        for(List<String> list : accounts){
            String p = list.get(1);
            for(int i=2; i<list.size(); i++){
                parentMap.put(find(list.get(i), parentMap), p);
            }
        }
        
        // // /**/
        // System.out.println();
        // for(Map.Entry<String, String>en : parentMap.entrySet()){
        //     System.out.println(en.getKey()+ ", " + en.getValue());
        // }
        HashMap<String, TreeSet<String>> unions = new HashMap<>();
        for(List<String> list : accounts){
            String p = find(list.get(1), parentMap);
            
            if(!unions.containsKey(p)){
                unions.put(p, new TreeSet<>());
            }
            
            for(int i=1; i<list.size(); i++){
                unions.get(p).add(list.get(i));    
            }
        }
        
        
        
        List<List<String>> res = new ArrayList<>();
        for(String p : unions.keySet()){
            
            List<String> list = new ArrayList<>(unions.get(p));
            list.add(0, userMap.get(p));
            res.add(list);
        }
        
        return res;
        
        
        
         
        
    }
    
    
    private String find(String s, Map<String, String> map){
        
        return s.equals(map.get(s))? s : find(map.get(s), map);
        
    }
    
}