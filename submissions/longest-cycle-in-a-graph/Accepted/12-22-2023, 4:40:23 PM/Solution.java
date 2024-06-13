// https://leetcode.com/problems/longest-cycle-in-a-graph

class Solution {
    public int longestCycle(int[] edges) {
        int len = edges.length;

        int[] indeg = new int[len];

        for(int i=0; i<len ;i++){
            if(edges[i]!=-1)
                indeg[edges[i]]++;
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<len; i++){
            if(indeg[i]==0) {
                q.offer(i);
                seen.add(i);
            }
        }


        while(!q.isEmpty()){

            int p = q.poll();
            if(edges[p]==-1) continue;
            indeg[edges[p]]--;

            if(indeg[edges[p]]==0){
                q.offer(edges[p]);
                seen.add(edges[p]);
            }
        }

        int max= -1;
        for(int i=0; i<len; i++){
            if(seen.contains(i)) continue;
            int cur = i ;
            int cnt = 0 ;
            while(!seen.contains(cur)){
                seen.add(cur);
                cnt++;
                cur=edges[cur];
            }

             System.out.println(i+ " " + cnt);

            max = Math.max(max, cnt);

        }
        return max;
    }
}