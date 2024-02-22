// https://leetcode.com/problems/shortest-cycle-in-a-graph

class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        Set<Integer>[] adj = new HashSet[n];

        for(int i=0; i<n; i++){
            adj[i] = new HashSet<>();
        }

        for(int[] e : edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int res = Integer.MAX_VALUE;
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            
            adj[a].remove(b);
            adj[b].remove(a);

            res = Math.min(res, bfs(a, b, adj));

            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        if(res==Integer.MAX_VALUE) return -1;
        
        return res+1;            
    }

    private int bfs(int a, int b, Set<Integer>[] adj){

        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        HashSet<Integer> seen = new HashSet<>();
        seen.add(a);

        int step=0;

        while(!q.isEmpty()){
            int siz = q.size();
            while(siz-->0){
                int p = q.poll();

                if(p==b) return step;

                for(int next: adj[p]){
                    if(seen.contains(next)) continue;
                    seen.add(next);
                    q.offer(next);
                }
            }
            step++;       
        }

        return Integer.MAX_VALUE;

    }
}