// https://leetcode.com/problems/course-schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        boolean[] told = new boolean[numCourses];
        
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
                told[i]=true;
            }
                
            
        }
        
        int curr = 0;
        while(!q.isEmpty()){
            
            int p = q.poll();
            for(int next : map.getOrDefault(p, new HashSet<Integer>())){
                
                if(told[next])
                    continue;
                
                indegree[next]--;
                
                if(indegree[next]==0){
                    q.offer(next);
                    told[next]=true;
                }
                    
            }
        }
        
        for(int i=0; i<numCourses; i++){
            if(told[i]==false)
                return false;
        }
        
        return true;
    }
    
    
    
}