// https://leetcode.com/problems/delete-duplicate-folders-in-system

class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {

        int len = paths.size();
        Map<String, List<Integer>> map = new HashMap<>(); // str, idxs

        for(int i=0; i<len ;i++){
            List<String> list = paths.get(i);
            StringBuilder sb = new StringBuilder();

            for(int j=list.size()-1; j>=0; j--){
                sb.append("/" +list.get(j));

                map.putIfAbsent(sb.toString(), new ArrayList<>());
                map.get(sb.toString()).add(i);

                if(map.containsKey(sb.toString())){
                    break;
                }
                
            }
        }


        Set<List<String>> res = new HashSet<>();
        for(String s : map.keySet()){
            if(map.get(s).size()>=2){
                List<Integer> idxs = map.get(s);
                for(int idx: idxs){
                    res.add(paths.get(idx));
                }
            }
        }

        return new ArrayList<>(res);

    }

    private void helper(List<String> list, int idx){
        if(list.size()==0) return;
        if(idx>=list.size()) return;





    }


}