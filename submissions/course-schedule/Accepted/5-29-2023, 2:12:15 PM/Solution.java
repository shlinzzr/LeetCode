// https://leetcode.com/problems/course-schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            
            map.putIfAbsent(b, new HashSet<>());
            map.get(b).add(a);
            
            indegree[a]++;
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
                
            
        }
        
        int curr = 0;
        while(!q.isEmpty()){
            
            int p = q.poll();
            for(int next : map.getOrDefault(p, new HashSet<Integer>())){
                
                
                indegree[next]--;
                
                if(indegree[next]==0){
                    q.offer(next);
                }
                    
            }
        }
        
        for(int i=0; i<numCourses; i++){
            if(indegree[i]>0)
                return false;
        }
        
        return true;
    }
    
    
    
}