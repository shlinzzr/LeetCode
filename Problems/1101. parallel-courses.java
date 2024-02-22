// https://leetcode.com/problems/parallel-courses

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int len = relations.length;

        int[] indeg = new int[n];
        List<Integer>[] adjs = new ArrayList[n];
        for(int i=0; i<n; i++){
            adjs[i] = new ArrayList<>();
        }


        for(int i=0; i<len; i++){
            int[] r = relations[i];
            indeg[r[1]-1]++; 
            adjs[r[0]-1].add(r[1]-1);

        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }

        int cnt= 0 ;
        int step = 0;
        while(!q.isEmpty()){
            int siz = q.size();
            step++;
            while(siz-->0){
                int p = q.poll();
                cnt++;
                for(int next : adjs[p]){
                    indeg[next]--;
                    if(indeg[next]==0){
                        q.offer(next);
                    }
                }
            }
        }

        return cnt==n ? step : -1;


    }
}