// https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph

class Solution {
    
    
    int[]parent;
    int[] weight;
    //  int[] rank;
    
    
    
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        
       
        parent = new int[n];
       
         weight = new int[n];
        //    rank = new int[n];

          Arrays.fill(weight, 131071);
        for(int i=0; i<n ; i++)
            parent[i]=i;
        
        
        
        int len = query.length;
        
        int[] res = new int[len];
        
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        
        for(int[] e : edges){
            
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            // if(find(u)!=find(v)){
                union(u, v, w);
            // }
            
            
            
            // g.putIfAbsent(u, new HashMap<>());
            // g.get(u).put(v, w);
              
            // g.putIfAbsent(v, new HashMap<>());
            // g.get(v).put(u, w);
        }
        
        
        for(int i=0; i<len; i++){
            int[] q = query[i];
            
            int a = q[0];
            int b = q[1];
            res[i] = walk(a, b);
               
        }
        
        return res;
    }

    public int walk(int x, int y) {
        if (x == y)
            return 0;
        if (find(x) != find(y))
            return -1;

        return weight[find(x)];
    }
    
    private int dfs( Map<Integer, Map<Integer, Integer>> g, int a, int b){
        
        
        Map<Integer, Integer> seen = new HashMap<>();
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{a, 0});
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            int cur = p[0];
            int w = p[1];
            
            
            Map<Integer, Integer> adjs = g.get(cur);
            for(int k : adjs.keySet()){
                
              
                
                int ww = cur==a ? adjs.get(k) : w & adjs.get(k);
                
                  System.out.println(cur+ " " + k + " "+w + " " + ww);
                
                if(!seen.containsKey(k) || seen.get(k)>ww){
                    seen.put(k, ww);
                    q.offer(new int[]{k, ww});
                }
                
            }
            
        }
        
        
        return seen.get(b);
        
         
        
    }
    
    
    private int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private void union(int a, int b,int w ){
        a = find(a);
        b = find(b);
        if(a<b){
            parent[b] = a;
        }else if(b<a){
            parent[a] = b;
        }

        // if (rank[a] < rank[b])
        //     parent[a] = b;
        // else
        //     parent[b] = a;
        // if (rank[a] == rank[b])
        //     rank[a]++;
         weight[a] = weight[b] = weight[a] & weight[b] & w;
    }
    
    /*
    
    Input:
3
[[0,2,7],[0,1,15],[1,2,6],[1,2,1]]
[[1,2]]
Output:
[1]
Expected:
[0]*/
    
}