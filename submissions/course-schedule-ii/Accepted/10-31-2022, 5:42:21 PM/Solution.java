// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] res = new int[numCourses];
        
        int[] indeg = new int[numCourses];
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] p: prerequisites){
            List<Integer> list = map.getOrDefault(p[1], new ArrayList<>());
            list.add(p[0]);
            map.put(p[1], list);
            indeg[p[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int idx=0;
        
        for(int i=0; i<numCourses; i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        
        
        while(!q.isEmpty()){
            
            int cur = q.poll();
            List<Integer> list = map.getOrDefault(cur, new ArrayList<>());
            for(int i: list){
                indeg[i]--;
                
                if(indeg[i]==0)
                    q.offer(i);
            }
            
            res[idx++] = cur;
        }
        
        for(int i=0; i<numCourses; i++){
            if(indeg[i]>0)
                return new int[0];
        }
         return res;
        
    }
    
}