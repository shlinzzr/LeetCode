// https://leetcode.com/problems/accounts-merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<List<String>>> map = new HashMap();
        for(List<String> ac : accounts){
            String name = ac.get(0);
            List<List<String>> list = map.getOrDefault(name , new ArrayList<>());
            
            
            ac.remove(0);
            
            
            if(list.size()==0){
                
                Collections.sort(ac);
                List<String> emailList = ac;
                list.add(emailList);
                map.put(name, list);
            }else{
                
                boolean isContain=false;
                for(int q=0; q<list.size(); q++){
                    List<String> emailList = list.get(q);
                    
                    HashSet<String> emailSet = new HashSet<>(emailList);
                    
                    for(int i=0; i<ac.size(); i++){
                        String email = ac.get(i);
                        if(emailSet.contains(email)){
                            emailSet.addAll(new HashSet<>(ac));
                            emailList = new ArrayList<>(emailSet);
                            Collections.sort(emailList);
                            list.set(q, emailList);
                            isContain=true;
                            break;
                        }
                    }
                    
                    
                }
                if(isContain==false){
                    Collections.sort(ac);
                    List<String> emailList = ac;
                    list.add(emailList);
                    map.put(name, list);
                }
            }
        }
        
        for(Map.Entry<String, List<List<String>>> en : map.entrySet()){
            String name = en.getKey();
            List<List<String>> list = en.getValue();
            for(List<String> emailList : list){
                emailList.add(0, name);
                res.add(emailList);
            }
        }
        
        return res;
        
        
    }
}