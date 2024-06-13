// https://leetcode.com/problems/accounts-merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        List<List<String>> res= new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for(List<String> list : accounts){
            String name = list.get(0);
            String root = list.get(1);
            emailToName.put(root, name);
            if(!map.containsKey(root))
                map.put(root, root);

            for(int i=2; i<list.size(); i++){
                map.put(list.get(i), root);
                emailToName.put(list.get(i), name);
            }
        }


        TreeSet<String> set = new TreeSet<>();
        for(List<String> list : accounts){
            for(int i=1; i<list.size(); i++){
                String root = find(map, list.get(i));
                map.put(list.get(i), root);
                set.add(root);
            }
        }

        // System.out.println(find(map, "Gabe3@m.co"));
        // System.out.println(map.get("Gabe3@m.co"));

        for(String root : set){
            // System.out.println(root);
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
}