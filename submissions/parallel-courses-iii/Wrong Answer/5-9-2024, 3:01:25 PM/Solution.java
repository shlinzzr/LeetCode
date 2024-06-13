// https://leetcode.com/problems/parallel-courses-iii

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {

        int[] indeg = new int[n+1];
        Map<Integer, Set<Integer>> preq = new HashMap<>();
        Map<Integer, Set<Integer>> next = new HashMap<>();

        for(int[] r : relations){
            int prevCourse = r[0];
            int nextCourse = r[1];

            indeg[nextCourse]++;
            preq.putIfAbsent(nextCourse, new HashSet<>());
            preq.get(nextCourse).add(prevCourse);

            next.putIfAbsent(prevCourse, new HashSet<>());
            next.get(prevCourse).add(nextCourse);
        }
        // dry-run
        // prev : 3: {1,2}
        // next : 1 : {3}, 2:{3}
        // indeg = 1, 2


        Queue<int[]> q = new LinkedList<>();
        // PriorityQueue<int[]> q = new PriorityQueue<>(
        //     (a,b)-> a[1]-b[1]
        // ); // courseIdx, currTime

        for(int i=1; i<=n; i++){
            if(indeg[i]==0){
                q.offer( new int[]{i, time[i-1]});
            }
        }

        // q : {1,0}, {2,0}


        boolean[] finished = new boolean[n+1];

        int curMax = 0;
        while(!q.isEmpty()){

            int[] p = q.poll();

            int idx = p[0];
            int cur = p[1];
            curMax = Math.max(curMax, cur);
            finished[idx] = true;

            Set<Integer> adjs = next.getOrDefault(idx, new HashSet<>());
            for(int adj : adjs){
                preq.get(adj).remove(idx);
                if(preq.get(adj).isEmpty()) q.offer(new int[]{adj, curMax+time[adj-1]});
            }

           

        }

        for(int i=1; i<n;i++){
            if(finished[i]==false) return -1;
        }

        return curMax;
        
    }
}