// https://leetcode.com/problems/network-delay-time


class Solution {
    
    int[] parent;
    int[] weight;
    
    Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        buildGraph(times, n);
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{k, 0}); // node, time
        int[] t = new int[n+1];
        Arrays.fill(t, Integer.MAX_VALUE);
        t[k] = 0;
        
        while(!q.isEmpty() ){
            int[] p = q.poll();
            int node = p[0];
            int time = p[1];
            Map<Integer, Integer> adjs = map.getOrDefault(node, new HashMap<>());
            for(int adj : adjs.keySet()){
                
                int cost= adjs.get(adj);
                
                if(time+cost < t[adj]){
                    t[adj] = time+cost;
                    q.offer(new int[]{adj, t[adj]});
                }
            }
        }
        
        int max = 0;
        for(int i=1; i<=n; i++){
            if(t[i]==Integer.MAX_VALUE) return -1;
            max = Math.max(max, t[i]);
        }
        return max;
        
//         parent = new int[n];
//         for(int i=0; i<n; i++){
//             parent[i] = i;
//         }
        
//         int len = times.length;
//         for(int[] t : times){
//             int u = t[0];
//             int v = t[1];
//             int cost = t[2];
            
//             union(u, v, cost)            
//         }
    }
    
    private void buildGraph(int[][] times, int n){
        
        for(int i=0; i<times.length; i++){
            int [] t = times[i];
            int u = t[0];
            int v = t[1];
            int cost = t[2];
            map.putIfAbsent(u, new HashMap<>());
            
            if(!map.get(u).containsKey(v) || map.get(u).get(v)<cost)
                map.get(u).put(v, cost);
        }
        
        
    }
    
//     private int find(int x){
//         if(parent[x]!=x) return find(parent[x]);
//         return parent[x];
//     }
    
//     private void union(int a,int b, int cost){
//         a= find(a);
//         b = find(b);
        
//         if(a==b) return ;
        
//         parent[b]= a;
//         weight[a] = cost + weight[b];
        
//     }
}