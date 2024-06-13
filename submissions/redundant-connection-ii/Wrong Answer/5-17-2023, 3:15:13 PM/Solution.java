// https://leetcode.com/problems/redundant-connection-ii

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int len = edges.length;
        
        List<int[]> list = new ArrayList<>();
        
        UnionFind uf = new UnionFind(len+1);
        
        
        for(int[] e : edges){
            
            int a=uf.find(e[0]);
            int b=uf.find(e[1]);
            
            if(a==b || uf.indegree[e[1]]>0){
                list.add(e);
                
                for(int i=0;i<=len; i++){
                    if(uf.parent[i]==e[1]){
                        list.add(new int[]{i, e[1]});                
                        uf.parent[i] = i;
                    }
                        
                }
            }
            
            
            else{
                uf.union(e[1], e[0]);
                 uf.indegree[e[1]]++;
            }
           
            
            
            
//             for(int i=0; i<len+1; i++){
                
//                 System.out.println(i +" " + uf.parent[i]);
//             }
//               System.out.println();
            
            
        }
        
        return list.get(list.size()-1);
        
        
    }
    
    
    class UnionFind{
        
        int[] parent;
        int[] weight;
        int[] indegree;
        
        public UnionFind(int n){
            parent = new int[n];
            weight = new int[n];
            indegree = new int[n];
            for(int i=0; i<n; i++){
                parent[i]= i;
            }
            Arrays.fill(weight, 1);
        
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
            
            // if(a<b){
            
            // if(weight[a]<=weight[b]){
                weight[a]+=weight[b];
                parent[b] = a;
            // }else{
            //     weight[b]+=weight[a];
            //     parent[a] = b;
            // }
        }
        
    }
}