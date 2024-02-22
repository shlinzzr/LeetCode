// https://leetcode.com/problems/course-schedule

class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int[] indeg = new int[n];

        HashMap<Integer, Set<Integer>> g = new HashMap<>();
        for(int[] p : pre) {
            int a = p[0];
            int b = p[1];

            indeg[a]++;

            g.putIfAbsent(b , new HashSet<>());
            g.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indeg[i]==0)
                q.offer(i);
        }


        int cnt= 0 ;
        while(!q.isEmpty()){
            int siz = q.size();
            while(siz-->0){

                int p = q.poll();

                cnt++;
                for(int next : g.getOrDefault(p, new HashSet<>())){
                    indeg[next]--;
                    if(indeg[next]==0)
                        q.offer(next);
                }
            }
        }

        return cnt==n;
    }
}