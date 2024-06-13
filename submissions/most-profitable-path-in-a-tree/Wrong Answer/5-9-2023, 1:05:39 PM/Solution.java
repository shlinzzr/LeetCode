// https://leetcode.com/problems/most-profitable-path-in-a-tree

class Solution {
    int max = 0;
    
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        
        for(int[] e: edges){
            adj.putIfAbsent(e[0], new HashSet<>());
            adj.putIfAbsent(e[1], new HashSet<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int len = amount.length;
        boolean[] opened = new boolean[len];
        
        int[] steps = new int[len];
        
        boolean[] seen = new boolean[len];
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(bob);
        seen[bob]=true;
        
       
        
        int step=0;
        while(!q.isEmpty()){
            int siz = q.size();
            
            for(int i=0; i<siz; i++){
                
                int p = q.poll();
                
                for(Integer next : adj.get(p)){
                    if(next==null)
                        continue;
                    
                    if(seen[next])
                        continue;
                    
                    seen[next]=true;
                    steps[next] = step;
                    
                    q.offer(next);
                }
                
            }
            
            step++;
        }
        
        seen = new boolean[len];
        seen[0]=true;
        dfs(adj, 0, 0, seen, false, amount, steps, 0);
        return max;
//         seen = new boolean[len];
//         q = new LinkedList<>();
//         q.offer(0);
//         seen[0]=true;
//         step=0;
//         int curr=0;
//          boolean compare = false;
        
//         int max = 0;
        
//         while(!q.isEmpty()){
            
//             int siz=q.size();
//             for(int i=0; i<siz; i++){
                
//                 int p = q.poll();
                
//                 if(steps[p]>step)
//                     curr+=amount[p];
//                 else if(steps[p]==step){
//                     curr += amount[p]/2;
//                     compare = true;
//                 }
                    
                
                
//                 System.out.println ( p + " " + curr);
                
//                  for(Integer next : adj.get(p)){
//                     if(next==null)
//                         continue;
                    
//                     if(seen[next])
//                         continue;
                     
//                     seen[next]=true;
//                     steps[next] = step;
                    
//                     q.offer(next);
//                 }
//             }
//         }
        
//         return curr;
        
        
        
    }
    
    
    
    private void dfs( HashMap<Integer, HashSet<Integer>> adj , int curr, int val, boolean[] seen, boolean compare, int[] amount, int[] steps, int step){
        
        
        HashSet<Integer> set = adj.get(curr);
        val += amount[curr];
        
        if(compare)
            max = Math.max(max, val);
        
        
        if(step>=steps[curr])
            compare=true;
        
        
        for(int next :  set){
            
            if(seen[next]){
                continue;
            }
            
            seen[next]= true;
            dfs(adj, next, val, seen, compare, amount, steps, step+1);
        }
        
    }
}