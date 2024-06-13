// https://leetcode.com/problems/accounts-merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        List<List<String>> res= new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // init
        for(List<String> list : accounts){
            String name = list.get(0);
            for(int i=1; i<list.size(); i++){
                map.put(list.get(i), list.get(i));
                emailToName.put(list.get(i), name);
            }
        }

        // union
        for(List<String> list : accounts){
            String root= list.get(1);
            for(int i=2; i<list.size(); i++){
                if(!root.equals(find(map, list.get(i)))){
                    union(map, root, list.get(i));
                }
            }
        }

        // chg email's parent to root;
        TreeSet<String> set = new TreeSet<>();
        for(Map.Entry<String, String> en : map.entrySet()){
            if(en.getKey().equals(en.getValue()))
                set.add(en.getKey());
        }
        for(String r : set){
            for(Map.Entry<String, String> en : map.entrySet()){
                if(r.equals(find(map, en.getValue())))
                    map.put(en.getKey(), p);
            }
        }

//      // this is wrong way to chg email's parent to root;
        // to check whether the email is root : map.get(x)==x
        // for(List<String> list : accounts){
        //     for(int i=1; i<list.size(); i++){
        //         String root = find(map, list.get(i));
        //         map.put(list.get(i), root);
        //         set.add(root);
        //     }
        // }

        for(String root : set){
            String name = emailToName.get(root);
            List<String> list = new ArrayList<>();

            for(Map.Entry<String, String> en : map.entrySet()){
                String email = en.getKey();
                String parent = en.getValue();

                if(root.equals(parent)){
                    list.add(email);
                }
            }

            Collections.sort(list);
            list.add(0, name);
            res.add(list);
        }

        return res;

    }

    private String find(Map<String, String> map, String x){
        if(map.get(x)!=x){
            map.put(x, find(map, map.get(x)));
        }

        return map.get(x);
    }

    private void union(Map<String, String> map, String a, String b){
        a = find(map, a);
        b = find(map, b);
        
        if(a.equals(b))
            return ;
        
        map.put(b, a);
    }
}