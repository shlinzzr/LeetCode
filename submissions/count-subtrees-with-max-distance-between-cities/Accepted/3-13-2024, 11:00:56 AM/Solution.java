// https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities

class Solution {
    HashMap<Integer, Set<Integer>> adj;
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {

        adj = buildMap(edges);

        int[] allow = new int[n];
        int[] rets = new int[n];
        int[] dist = new int[n];

        for (int state=1; state<(1<<n); state++)
        {
            int start = 0;
            int count = 0;
            for (int i=0; i<n; i++)
            {
                if (((state>>i)&1)==1)
                {
                    allow[i]=1;
                    start = i;
                    count++;
                }                    
                else
                    allow[i]=0;
            }

           for (int i=0; i<n; i++)
                dist[i] = -1;
            int v1 = bfs(start, dist, allow);

            int countVisited = 0;
            for (int i=0; i<n; i++)
                countVisited += (dist[i]!=-1) ? 1 : 0;
            if (countVisited!=count)
                continue;
            
            for (int i=0; i<n; i++)
                dist[i] = -1;
            int v2 = bfs(v1, dist, allow);


             System.out.println("v1="+v1 + " v2="+v2);

            int maxDist = 0;
            for(int i=0; i<n; i++){
                maxDist = Math.max(maxDist, dist[i]);
            }
            
            rets[maxDist]++;
        }
        // rets[0] = 0;
        // rets.erase(rets.begin());

        int[] res = new int[n-1];
        for(int i=1; i<n; i++){
            res[i-1] = rets[i]; 
        }

        return res;        
    }
    
    private int bfs(int start, int[] dis, int[] allow)
    {
        int n = dis.length;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);       
        dis[start] = 0; 
        int maxDis = 0;
        int maxId = start;
        
        while (!q.isEmpty()) 
        { 
            int cur = q.poll();
            for (int next: adj.get(cur)) 
            {       
                if (allow[next]==0) continue;
                if (dis[next] == -1) 
                { 
                    q.offer(next);   
                    dis[next] = dis[cur] + 1; 
                    if (dis[next] > maxDis)
                    {
                        maxDis = dis[next];
                        maxId = next;
                    }
                } 
            } 
        }
        return maxId; 
    }

    private HashMap<Integer,Set<Integer>> buildMap(int[][] edges){

        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        
        int len = edges.length;
        for(int i=0; i<len; i++){
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;
            map.putIfAbsent(u, new HashSet<>());
            map.putIfAbsent(v, new HashSet<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }

        return map;
    }
}
