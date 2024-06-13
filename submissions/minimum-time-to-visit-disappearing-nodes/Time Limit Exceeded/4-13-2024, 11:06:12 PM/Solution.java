// https://leetcode.com/problems/minimum-time-to-visit-disappearing-nodes

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] dis) {
        int len = n;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0]=0;
        
        Map<Integer, List<int[]>> g= new HashMap<>();
        
        for(int[] e : edges){
            g.putIfAbsent(e[0], new ArrayList<>());
            g.get(e[0]).add(new int[]{e[1], e[2]});
            
            g.putIfAbsent(e[1], new ArrayList<>());
            g.get(e[1]).add(new int[]{e[0], e[2]});
        }
        
        Queue<int[]> q = new LinkedList<>(); // node , time
        
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            int siz = q.size();
            while(siz-->0){
                int[] p = q.poll();
                
                int cur = p[0];
                int time = p[1];
                
                List<int[]> adjs = g.getOrDefault(cur, new ArrayList<>());
                
                for(int[] adj : adjs){
                    
                    int next = adj[0];
                    int cost = adj[1];
                    
                    
                    
                    if( time+cost<res[next] && time+cost < dis[next] ){
                        
                        // System.out.println("net= " + next + " t=" + time+ " cost=" + cost + " res="  + res[next]);
                        res[next] = time + cost;
                        q.offer(new int[]{next, time+cost});
                    }
                    
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