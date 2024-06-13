// https://leetcode.com/problems/count-the-number-of-complete-components

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n); 
        HashSet<String> set = new HashSet();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[]e : edges){
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            set.add(e[0]+"-"+e[1]);
            
            uf.union(e[0], e[1]);
        }
        
        int cnt=0;
        
        for(int i=0; i<n; i++){
            
            if(uf.parent[i]==i){
                if(isCon(i, n, set, uf))
                   cnt++;
            }
            
        }
        
                   
        return cnt;
        
        
        
        
    }
    
    
    private boolean isCon(int root, int n, HashSet<String> set, UnionFind uf){
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(uf.parent[i]==root)
                list.add(i);
        }
        
        System.out.println(list);
         System.out.println(set.contains(4+"-"+5));
        
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                if(i==j)
                    continue;
                
                if(!set.contains( list.get(i)+"-"+list.get(j)))
                    return false;
            }
        }
        return true;
        
        
        
    }
    
   class UnionFind{
        
        int[] parent;
        int[] weight;
        
        public UnionFind(int n){
            parent = new int[n];
            weight = new int[n];
            for(int i=0; i<n; i++){
                parent[i]= i;
            }
        
        }
        public int find(int x){
            
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            
            return parent[x];
        }
        
        public void union(int a, int b){

            a=find(a);
            b=find(b);
            
            if(a==b)
                return;
            
            if(weight[a]<=weight[b]){
                weight[a]+=weight[b];
                parent[b] = a;
            }else{
                weight[b]+=weight[a];
                parent[a] = b;
            }
        }
        
    }
}