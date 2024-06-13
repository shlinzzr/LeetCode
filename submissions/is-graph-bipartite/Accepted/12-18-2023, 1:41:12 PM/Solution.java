// https://leetcode.com/problems/is-graph-bipartite

class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> seta = new HashSet<>();
        Set<Integer> setb = new HashSet<>();

        int n = graph.length;
        boolean[] seen = new boolean[n];

        for(int a=0; a<n; a++){

            if(seta.contains(a) || setb.contains(a)) continue;

            Queue<Integer> q = new LinkedList<>();
            q.offer(a);

            boolean aturn = true;
            while(!q.isEmpty()){
                int siz = q.size();
                for(int i=0; i<siz; i++){
                    int p = q.poll();
                    seen[p]=true;

                    for(int adj : graph[p]){


                        if(aturn){
                            if(seta.contains(adj)) return false;
                            setb.add(adj);

                            if(!seen[adj])
                                q.offer(adj);

                        }else{
                            if(setb.contains(adj)) return false;
                            seta.add(adj);
                            if(!seen[adj])
                                q.offer(adj);
                        }

                    }
                }
                aturn = !aturn;
            }

        // for(int i=0; i<n ; i++){
        //     if(seen[i]==false)
        //         return false;
        // }
        }


        return true;

    }
}