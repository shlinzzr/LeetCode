// https://leetcode.com/problems/shortest-cycle-in-a-graph

class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map  = new HashMap<>();
        for(int[] e : edges){
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
    
    
    
    
    
    int min=0;
    
        for(int st=0; st<n; st++){
            int prev = -1;
            boolean[] seen = new boolean[n];
            seen[st]=true;
            Queue<Integer> q = new LinkedList<>();
            q.offer(st);
            int step=0;

            while(!q.isEmpty()){

                int curr = q.poll();

                List<Integer> list = map.get(curr);
                for(int next : list){

                    if(next==prev)
                        continue;

                    if(seen[next]==true)
                        min = Math.min(min, step);

                    seen[next]=true;
                    q.offer(next);

                }

                step++;

            }
        }
        return min;
    }
    
    
    
}