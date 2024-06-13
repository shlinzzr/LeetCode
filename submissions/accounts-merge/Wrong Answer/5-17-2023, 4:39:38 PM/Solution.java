// https://leetcode.com/problems/accounts-merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        
        HashMap<String, String> nameMap = new HashMap<>();
        
        UnionFind uf = new UnionFind();
        
        for(List<String> list : accounts){
            
            String name = list.get(0);
            
            for(int i=1; i<list.size(); i++){
                uf.parent.put(list.get(i), list.get(i));
                nameMap.put(list.get(i), name);
            }
        }
        
        
        for(List<String> list : accounts){
            
            String root = list.get(1);
            
            for(int i=2; i<list.size(); i++){
                
                if(!root.equals(uf.find(list.get(i)))){
                    uf.union(root, uf.find(list.get(i)));
                }
            }
        }
        
        
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        
        for(Map.Entry<String, String> en : uf.parent.entrySet()){
            map.putIfAbsent(en.getValue(), new ArrayList<>());
            map.get(en.getValue()).add(en.getKey());
        }
        
        for(Map.Entry<String, List<String>> en : map.entrySet()){
            List<String> list = en.getValue();
            Collections.sort(list);
            list.add(0, nameMap.get(en.getKey()));
            
            res.add(list);
        
        }
        
        return res;
        
        
        
    }
    
     class UnionFind{
        
         
         HashMap<String, String> parent;
         
        
        public UnionFind(){
            
            parent = new HashMap<>();
        }
        
         public String find(String a){
             
             if(a.equals(parent.get(a))){
                 return a;
             }
             
             parent.put( a, find(parent.get(a)) );
             return parent.get(a);
         }
        
        public boolean union(String a, String b){
            
             a = find(a);
             b = find(b);
            
            if(a!=null && a.equals(b)){
                return false;
            }
            
            parent.put(b, a);
            return true;
        }
         
         
        
//         public void union(int a, int b){
            
//             a = find(a);
//             b = find(b);
            
//             if(a==b)
//                 return ;
            
//             if(weight[a]>= weight[b]){
//                 weight[a]+=weight[b];
//                 parent[b] = a;
//             }else{
//                 weight[b]+=weight[a];
//                 parent[a] = b;
//             }
            
            
//         }
        
//         public int find(int x){
//             if(parent[x] ==x)
//                 return x;
            
//             parent[x] = find(parent[x]);
//             return parent[x];
//         }
        
        
    }
}