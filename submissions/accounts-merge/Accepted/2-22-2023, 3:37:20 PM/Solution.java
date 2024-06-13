// https://leetcode.com/problems/accounts-merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind uf = new UnionFind(size);
        
        
        
        HashMap<String, Integer> emailToId = new HashMap<>();
        for(int i = 0; i < size; i++) {
            List<String> list = accounts.get(i);
            for(int j=1; j<list.size(); j++){
                String email = list.get(j);
                
                if(emailToId.containsKey(email)){
                    uf.union(emailToId.get(email), i);
                    // uf.union(i, emailToId.get(email));
                }else{
                    emailToId.put(email, i);   
                }
            }
        }
        
        
        HashMap<Integer, List<String>> idToEmails = new HashMap<>();
        for(String key : emailToId.keySet()) {
            int root = uf.find(emailToId.get(key));
            
            idToEmails.putIfAbsent(root, new ArrayList<>());
            idToEmails.get(root).add(key);
        }
        
        List<List<String>> res =  new ArrayList<>();
        for(Integer id : idToEmails.keySet()) {
            List<String> emails = idToEmails.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            res.add(emails);
        }
        
        return res;
        
    }
    
    
    
    
    
    class UnionFind{
        
        int[] parent;
        int[] weight;
        
        
        public UnionFind(int num){
            parent = new int[num];
            weight = new int[num];
            
            for(int i=0; i<num; i++){
                parent[i] = i;
                weight[i] = 1;
            }
        }
        /*
        private void union(int a, int b){
            int roota = find(a);
            int rootb = find(b);
            if(roota==rootb)
                return ;
            
            if(weight[roota]>weight[rootb]){
                weight[roota] += weight[rootb];
                parent[rootb] = roota;
            }else{
                weight[rootb] += weight[roota];
                parent[roota] = rootb;
            }
        }
        
        
        
        private int find(int a){
            if(parent[a]==a)
                return a;
            
            // return find(parent[a]);
            
            parent[a] = find(a); // path compression
            return parent[a];
        }*/
        
         public void union(int a, int  b) {
            int rootA = find(a);
            int rootB = find(b);
            
            if (rootA == rootB) {
                return;
            }
            
            if (weight[rootA] > weight[rootB]) {
                parent[rootB] = rootA;
                weight[rootA] += weight[rootB];
            } else {
                parent[rootA] = rootB;
                weight[rootB] += weight[rootA];
            }
        }
        
        public int find(int a) {
            if (parent[a] == a) {
                return a;
            }
            
            parent[a] = find(parent[a]);
            return parent[a];
        }
        
    }
}