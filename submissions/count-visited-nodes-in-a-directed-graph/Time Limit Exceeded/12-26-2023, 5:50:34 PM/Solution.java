// https://leetcode.com/problems/count-visited-nodes-in-a-directed-graph

class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        
        int[] res = new int[n];

        for(int i=0; i<n; i++){
            Set<Integer> set = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);

            int step = 0;
            while(!q.isEmpty()){
                int p = q.poll();
                
                if(set.add(p)==false){
                    break;
                }

                q.offer(edges.get(p));
                // System.out.println(i + " " + p);

                step++;
            }

            res[i] = step;

        }

        return res;
    }
}