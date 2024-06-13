// https://leetcode.com/problems/accounts-merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        
        HashMap<String, List<String>> emailGroup = new HashMap<>(); // mainEmail, sameEmail
        HashMap<String, String> emailUser = new HashMap<>(); // mainEmail, user
         
        int len = accounts.size();
        for(int i=0; i<len; i++){
            
            List<String> list = accounts.get(i);
            String user = list.get(0);
            
            boolean hasMainEmail=false;
            String mainEmail = null;
            for(int j=1; j<list.size();j++){
                String m = list.get(j);
                if(emailGroup.containsKey(m)){
                    mainEmail = m;
                    break;
                }
            }
            
            if(mainEmail==null){
                mainEmail=list.get(1);
                emailGroup.put(mainEmail, new ArrayList<>());
                emailUser.put(mainEmail, user);
            }
            
            emailGroup.get(mainEmail).addAll(list);
            emailGroup.get(mainEmail).remove(user);
            
        }
        
        
        
        HashMap<String, HashSet<String>> map = new HashMap<>();
        
        Iterator<Map.Entry<String,  List<String>>> itt = emailGroup.entrySet().iterator();
        while (itt.hasNext()) {
            Map.Entry<String,  List<String>> en = itt.next();
            System.out.println(en.getKey() + " " + en.getValue());
        }
        
        
        
        
        boolean redo = true;
        while(redo){
            redo=false;
            
            
            Iterator<Map.Entry<String,  List<String>>> it = emailGroup.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String,  List<String>> en = it.next();
                List<String> list = en.getValue();
                for(String s : list){
                    if(emailGroup.containsKey(s) && !map.containsKey(s)){
                        emailGroup.get(s).addAll(new HashSet<>(list));
                        
                        map.put(s, new HashSet<>());
                        map.get(s).addAll( new HashSet<>(emailGroup.get(s))  );
                        redo=true;
                        // it.remove();
                        break;
                    }
                    
                    if(s.equals(list.get(list.size()-1))){
                        map.put(en.getKey(), new HashSet<>(en.getValue()));
                    }
                }
            }
        }
        
        System.out.println(map.size());
        
        for(Map.Entry<String, HashSet<String>> en : map.entrySet()){
            List<String> list = new ArrayList<>();
            
            list.addAll(new ArrayList<>(en.getValue()));
            Collections.sort(list);
            list.add(0, emailUser.get(en.getKey()));
            res.add(list);
        }
        
        return res;
        
        
        
         
        
    }
}