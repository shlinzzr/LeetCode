// https://leetcode.com/problems/sentence-similarity-ii

class Solution {
    public boolean areSentencesSimilarTwo(String[] a, String[] b, List<List<String>> pairs) {
        
        if (a.length != b.length) return false;
        Map<String, String> m = new HashMap<>();
        for (List<String> p : pairs) {
            String parent1 = find(m, p.get(0)), parent2 = find(m, p.get(1));
            if (!parent1.equals(parent2)) m.put(parent1, parent2);
        }

        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i]) && !find(m, a[i]).equals(find(m, b[i]))) return false;

        return true;
    }

    private String find(Map<String, String> m, String s) {
        if (!m.containsKey(s)) m.put(s, s);
        return s.equals(m.get(s)) ? s : find(m, m.get(s));
    }
        
        
        
        
    
    class UnionFind{
        
        int[] parent;
        int[] weight;
        
        public UnionFind(int n){
            parent = new int[n];
            weight = new int[n];
            
            for(int i=0; i<n; i++){
                parent[i]=i;
                weight[i]=1;
            }
        }
        
        public int find(int a){
            if(parent[a]==a)
                return a;
            
            parent[a] = find(parent[a]);
            return parent[a];
        }
        
        public boolean union(int a, int b){
            
            a = find(a);
            b = find(b);
            
            if(a==b){
                return false;
            }
            
            if(weight[a]<=weight[b]){
                parent[b] = a;
                weight[a] += weight[b];
            }else{
                parent[a] =b;
                weight[b] += weight[a];
            }
            return true;
            
            
        }
        
    }
}