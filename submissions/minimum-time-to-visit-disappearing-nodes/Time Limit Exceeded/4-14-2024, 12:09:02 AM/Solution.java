// https://leetcode.com/problems/minimum-time-to-visit-disappearing-nodes

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] dis) {
        int len = n;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0]=0;
        
        
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        // Map<Integer, List<int[]>> g = new HashMap<>();
        
        for(int[] e : edges){
            
            int u = e[0];
            int v = e[1];
            int c = e[2];
            
            g.putIfAbsent(u, new HashMap<>());
            g.putIfAbsent(v, new HashMap<>());
            
            if(!g.get(u).containsKey(v) || g.get(u).get(v)>c){
                g.get(u).put(v, c);
            }
            
            
            if(!g.get(v).containsKey(u) || g.get(v).get(u)>c){
                g.get(v).put(u, c);
            }
            
            
            
//             g.putIfAbsent(e[0], new ArrayList<>());
//             g.get(e[0]).add(new int[]{e[1], e[2]});
            
//             g.putIfAbsent(e[1], new ArrayList<>());
//             g.get(e[1]).add(new int[]{e[0], e[2]});
        }
        
        
//         for(int k : g.keySet()){
//             Collections.sort(g.get(k), (a,b)-> a[1]-b[1]);
//         }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( 
            (a,b) -> a[1]-b[1]
        ); // node , time
        
        pq.offer(new int[]{0,0});
        
        while(!pq.isEmpty()){
            int[] p = pq.poll();

            int cur = p[0];
            int time = p[1];
            

            Map<Integer, Integer> adjs = g.getOrDefault(cur, new HashMap<>());

            for(int next : adjs.keySet()){

                int cost = adjs.get(next);


                if( time+cost<res[next] && time+cost < dis[next] ){
                    // System.out.println(
                    // System.out.println("net= " + next + " t=" + time+ " cost=" + cost + " res="  + res[next]);
                    res[next] = time + cost;
                    pq.offer(new int[]{next, time+cost});
                }

            }
                
            
           
        }
        
        
        for(int i=0; i<len ; i++){
            if(res[i]==Integer.MAX_VALUE){
                res[i] = -1;
            }
        }

        return res;
        
    }
}