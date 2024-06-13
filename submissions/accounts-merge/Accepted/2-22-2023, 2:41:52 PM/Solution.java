// https://leetcode.com/problems/accounts-merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
       
        
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, String> nameMap = new HashMap<>();
        
        for(List<String> list : accounts){
            String name = list.get(0);
            for(int j=1; j<list.size(); j++){
                
                parent.put(list.get(j), list.get(j));
                nameMap.put(list.get(j), name);
            }
        }
        
        for(List<String> list : accounts){
            String root = find(list.get(1), parent);
            for(int i=2; i<list.size(); i++){
                parent.put(find(list.get(i), parent), root);
            }
        }
        
        HashMap<String, TreeSet<String>> unions = new HashMap<>();
        for(List<String> list : accounts){
            
            String root = find(list.get(1), parent);
            unions.putIfAbsent(root, new TreeSet<>());
            for(int i=1; i<list.size(); i++){
                unions.get(root).add(list.get(i));
            }
        }
        
        /*
        */
        List<List<String>> res = new ArrayList<>();
        for(String root : unions.keySet()){
            List<String> emails =  new ArrayList<>(unions.get(root));
            emails.add(0, nameMap.get(root));
            res.add(emails);
        }
        
        return res;
        
        
        
        
        
    }
    
    private String find(String x, HashMap<String, String> map){
        
        if(!map.get(x).equals(x)) return find( map.get(x), map);
        
        return x;
    }
}