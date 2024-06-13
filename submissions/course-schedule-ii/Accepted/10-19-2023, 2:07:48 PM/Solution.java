// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indeg = new int[numCourses];
        for(int[] pre : prerequisites){
            map.putIfAbsent(pre[1], new ArrayList<>());
            map.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }

        List<Integer> list = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indeg[i]==0){
                q.offer(i);
                indeg[i]=-1;
            }
                
        }
        
        while(!q.isEmpty()){

            int p = q.poll();
            list.add(p);
            List<Integer> next = map.getOrDefault(p, new ArrayList<>());
            for(int n : next){
                indeg[n]--;

                if(indeg[n]==0)
                    q.offer(n);
            }
        }
        

        if(list.size()< numCourses)
            return new int[0];

        int[] res = new int[numCourses];
        for(int i=0;i<numCourses; i++){
            res[i] = list.get(i);
        }


        return res;

    }
}