// https://leetcode.com/problems/accounts-merge

class Solution {

    Map<String, String> parent = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<String>> map = new HashMap<>(); // root, emails
        Map<String, String> nameMap = new HashMap<>();
        // init
        for(List<String> list : accounts){
            for(int i=1; i<list.size(); i++){
                parent.put(list.get(i), list.get(i));
            }
        }
        
        //merge
        for(List<String> list : accounts){
            String root = list.get(1);
            for(int i=1;i<list.size(); i++){
                parent.put(find( list.get(i)) , find(root));
            }
        }


        for(List<String> list : accounts){
            for(int i=1; i<list.size(); i++){
                String org = list.get(i);
                String root = find(org);
                map.putIfAbsent(root, new ArrayList<>());

                if(!map.get(root).contains(org))
                    map.get(root).add(org);
            }


            String name = list.get(0);
            nameMap.put(find(list.get(1)), name);
        }

        // List<List<String>> res = new ArrayList<>(map.values());
        List<List<String>> res= new ArrayList<>();
        for(String k : map.keySet()){

            List<String> list =  new ArrayList( new HashSet<>(map.get(k)));
            Collections.sort(list);
            list.add(0, nameMap.get(find(list.get(0))));
            res.add(list);
        }

        // for(List<String> sub : res){
        //     Collections.sort(sub);
        //     sub.add(0, nameMap.get(find(sub.get(0))));
        // }

        return res;



        
    }

    private String find(String x){
        if(!parent.get(x).equals(x)) parent.put(x, find(parent.get(x)));
        return parent.get(x);
    }
}