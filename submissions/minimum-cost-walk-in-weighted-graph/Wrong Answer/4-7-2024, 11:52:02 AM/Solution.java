// https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph

class Solution {
    
    
    int[]parent;
    
    
    
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        
        parent = new int[n];
        for(int i=0; i<n ; i++)
            parent[i]=i;
        
        
        
        int len = query.length;
        
        int[] res = new int[len];
        
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        
        for(int[] e : edges){
            
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            if(find(u)!=find(v)){
                union(u, v);
            }
            
            
            
            g.putIfAbsent(u, new HashMap<>());
            g.get(u).put(v, w);
              
            g.putIfAbsent(v, new HashMap<>());
            g.get(v).put(u, w);
        }
        
        
        for(int i=0; i<len; i++){
            int[] q = query[i];
            
            int a = q[0];
            int b = q[1];
            
            if(find(a)!=find(b)){
                 res[i]= -1;
                continue;
            }
            
            
            res[i] = dfs(g, a, b);
               
        }
        
        return res;
    }
    
    
    private int dfs( Map<Integer, Map<Integer, Integer>> g, int a, int b){
        
        
        Map<Integer, Integer> seen = new HashMap<>();
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{a, Integer.MAX_VALUE});
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            int cur = p[0];
            int w = p[1];
            
            
            Map<Integer, Integer> adjs = g.get(cur);
            for(int k : adjs.keySet()){
                
              
                
                int ww = w & adjs.get(k);
                
                  // System.out.println(a+ " " + k + " "+w + " " + ww);
                
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
    
    private void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a<b){
            parent[b] = a;
        }else if(b<a){
            parent[a] = b;
        }
    }
    
    
    
}