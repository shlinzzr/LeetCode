// https://leetcode.com/problems/collect-coins-in-a-tree

class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {

        int n = coins.length;

        Set<Integer>[] adj = new HashSet[n];
        for(int i=0; i<n ;i++)
            adj[i] = new HashSet<>();
        
        int[] deg = new int[n];

        for(int[] e : edges){
            deg[e[0]]++;
            deg[e[1]]++;
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        // remove dummy node without coins
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(deg[i]==1 && coins[i]==0){
                q.offer(i);
            }
        }

        Set<Integer> deleted = new HashSet<>();
        while(!q.isEmpty()){
            int siz = q.size();
            while(siz-->0){
                int p = q.poll();
                deleted.add(p);

                for(int nxt : adj[p]){
                    deg[nxt]--;
                    adj[nxt].remove(p);
                    if(deg[nxt]==1 && coins[nxt]==0)
                        q.offer(nxt);
                }
            }
        }


        // remove node where depth<=2
        int[] depth = new int[n];
        Arrays.fill(depth, -1);
        for(int i=0; i<n; i++){
            if(deg[i]==1 && !deleted.contains(i)){
                q.offer(i);
                depth[i]=1;
            }
        }

        while(!q.isEmpty()){
            int siz = q.size();
            while(siz-->0){
                int cur = q.poll();
                for(int nxt : adj[cur]){
                    deg[nxt]--;
                    adj[nxt].remove(cur);
                    depth[nxt] = Math.max(depth[nxt], depth[cur]+1);
                    if(deg[nxt]==1){
                        q.offer(nxt);
                    }
                }
            }
        }

        int nodeCnt = 0;
        for(int i=0; i<n; i++){
            if(depth[i]>=3)
                nodeCnt++;
        }

        if(nodeCnt>=1){
            return (nodeCnt-1)*2;
        }else
            return 0;
    }
}