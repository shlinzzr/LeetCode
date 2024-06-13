// https://leetcode.com/problems/accounts-merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        
        
        int len= accounts.size();
        int[] parents = new int[len];
        for(int i=0; i<len; i++){
            parents[i] = i;
        }
        
        UnionFind uf = new UnionFind(len);
        
        
        HashMap<String, Integer> emailToId = new HashMap<>();
        for(int i=0; i<len ; i++){
            List<String> list = accounts.get(i);
            for(int j=1; j<list.size(); j++){
                String email = list.get(j);
                
                if(emailToId.containsKey(email)){
                    // parents[i] = emailToId.get(email);
                    uf.union(emailToId.get(email), i);
                } else{
                    emailToId.put(email, i);
                }
            }
        }
        
        HashMap<Integer, List<String>> idToEmails = new HashMap<>();
        for(Map.Entry<String, Integer> en : emailToId.entrySet()){
            String email = en.getKey();
            int key = emailToId.get(email);
            int root = uf.find(key);
            
            idToEmails.putIfAbsent(root, new ArrayList<>());
            idToEmails.get(root).add(email);
        }
        
        
        List<List<String>> res = new ArrayList<>();
        
        for(Map.Entry<Integer, List<String>> en : idToEmails.entrySet()){
            
            List<String> list = en.getValue();
            Collections.sort(list);
            int id = en.getKey();
            String usr = accounts.get(id).get(0);
            list.add(0, usr);
            
            res.add(new ArrayList<>(list));
            
        }
        return res;
        
        
        
    }
    
    private int find(int[] parents, int x){
        
        if(parents[x]==x)
            return x;
        
        parents[x] = find(parents, parents[x]);
        return parents[x];
        
    }
    
    class UnionFind{
        
        int[] parents;
        int[] weights;
        
        public UnionFind(int n){
            parents = new int[n];
            weights = new int[n];
            for(int i=0; i<n; i++){
                parents[i] = i;
                weights[i] = 1;
            }
            
            
            
        }
        
        public void union(int a, int b){
            
            int rootA = find(a);
            int rootB = find(b);
            
            if(rootA==rootB)
                return;
            
            if(weights[rootA]>weights[rootB]){
                weights[rootA] += weights[rootB];
                parents[rootB] =  rootA;
            }else{
                weights[rootB] += weights[rootA];
                parents[rootA] =  rootB;
            }
        }
        
        public int find(int x){
            
            if(parents[x]==x)
                return x;
            
            parents[x] = find(parents[x]);
            return parents[x];
        }
        
    }
    
}