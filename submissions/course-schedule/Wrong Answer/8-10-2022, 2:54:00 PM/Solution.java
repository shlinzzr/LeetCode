// https://leetcode.com/problems/course-schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        
        for(int[] req : prerequisites){
            int take = req[0];
            int pre = req[1];
            
            List<Integer> list = map.get(pre);
            if(list==null){
                list = new ArrayList<>();
                indegree[take]++;
            }
            list.add(take);
            map.put(pre, list);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0)
                queue.offer(i);
        }
        
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> list = map.get(cur);
            if(list==null)
                continue;
            
            for(int i : list){
                indegree[i]--;
                if(indegree[i]==0)
                    queue.offer(i);
            }
        }

        
        
         for(int i=0; i<numCourses; i++){
            if(indegree[i]>0)
                return false;
        }
    
        return true;
        
        
        
        
        
        
        
        
        
    }
}