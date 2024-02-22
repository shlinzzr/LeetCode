// https://leetcode.com/problems/minimum-height-trees

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
            
        
        
        
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] e : edges){
            
            map.putIfAbsent(e[0], new HashSet<>());
            map.putIfAbsent(e[1], new HashSet<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        
        
        List<Integer> leaves = new ArrayList<>();
        for(Map.Entry<Integer, Set<Integer>> en : map.entrySet()){
            if(en.getValue().size()==1 ){
                int leaf = en.getKey();
                leaves.add(leaf);
            }
        } 
        
        
        
        
        while(n>2){
            
            n-=leaves.size();
            
            List<Integer> next = new ArrayList<>();
            
            for(int leaf : leaves){
                int parent = new ArrayList<>(map.get(leaf)).get(0);
                map.get(parent).remove(leaf);
                if(map.get(parent).size()==1)
                    next.add(parent);
            }
            
            leaves = next;
        }
        
        return leaves;
        
        
//         Set<Integer> del = new HashSet<>();
        
//         boolean valid = true;
//         while(valid){
//             valid = false;
//             for(Map.Entry<Integer, Set<Integer>> en : map.entrySet()){
//                 if(en.getValue().size()==1 && !del.contains(en.getKey())){
//                     valid=true;
//                     int leaf = en.getKey();
//                     int parent = new ArrayList<>(en.getValue()).get(0);
//                     map.get(parent).remove(leaf);
//                     del.add(leaf);
//                 }
//             } 
//         }
        
//         for(int i=0; i<n; i++){
//             if(!del.contains(i))
//                 res.add(i);
//         }
        // return res;
        
        
    }
}