// https://leetcode.com/problems/all-paths-from-source-lead-to-destination

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        

        boolean[] toDest = new boolean[];
        toDest[destination] = true;

        boolean[] seen = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        seen[source] = true;


        int out=0;

        HashMap<Integer, List<Integer>> g = new HashMap<>();
        for(int[] e: edges){
            g.putIfAbsent(e[0], new ArrayList<>());
            g.get(e[0]).add(e[1]);
            if(e[0]==source)       
                out++;
        }
        
        while(!q.isEmpty()){
            for(int i=q.size(); i>=0; i--){
                int p = q.poll();
                seen[p]=true;
                
                List<Integer> adj = g.get(p);





            }
        }

    }
}