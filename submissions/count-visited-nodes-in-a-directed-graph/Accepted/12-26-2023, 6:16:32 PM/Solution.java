// https://leetcode.com/problems/count-visited-nodes-in-a-directed-graph

class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] indeg = new int[n];
        for(int i=0; i<n; i++){
            indeg[edges.get(i)]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indeg[i]==0)
                q.offer(i);
        }


        int[] res = new int[n];

        while(!q.isEmpty()){

            int siz = q.size();
            while(siz-->0){
                int p = q.poll();

                int next = edges.get(p);
                indeg[next]--;
                if(indeg[next]==0){
                    q.offer(next);
                }
            }
        }

        // for(int i=list.size()-1; i>=0; i--){
        //     List<Intege> sub = list.get(i);
        //     for(int b : sub){
        //         res[b] = i+1;
        //     }
        // }
        
        for(int i=0; i<n; i++){
            if(indeg[i]==0) continue;
            if(res[i]!=0) continue;

            int j=i;
            int len = 1;
            while(edges.get(j)!=i){
                len++;
                j = edges.get(j);
            }

            j=i;
            while(edges.get(j)!=i){
                res[j] = len;
                j = edges.get(j);
            }
        }

        for(int i=0; i<n; i++){
            if(indeg[i]!=0) continue;

            dfs(i, res, edges);
        }

        return res;




    }

    private int dfs(int i, int[] res, List<Integer> edges){
        if(res[i]!=0)
            return res[i];
        res[i] = dfs(edges.get(i), res , edges)+1;
        return res[i];

    }
}