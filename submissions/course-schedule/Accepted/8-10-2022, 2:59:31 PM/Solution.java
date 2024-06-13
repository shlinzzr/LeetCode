// https://leetcode.com/problems/course-schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     
        
        //https://www.youtube.com/watch?v=fskPWs3Nuhc
        
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        
        
        for(int[] req : prerequisites){
            int take = req[0];
            int pre = req[1];
            
            indegree[take]++;
            
            List<Integer> list = map.getOrDefault(pre, new ArrayList<>());
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