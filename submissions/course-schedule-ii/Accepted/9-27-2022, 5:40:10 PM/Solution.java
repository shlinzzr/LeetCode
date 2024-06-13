// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] pre :prerequisites){
            
            List<Integer> list = map.getOrDefault(pre[1], new ArrayList<>());
            list.add(pre[0]);
            map.put(pre[1], list);
            
            indegree[pre[0]]++;
        }
        
        int[] res = new int[numCourses];
        
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0)
                queue.add(i);
        }
    
        int idx=0;
        while(!queue.isEmpty()){
            int p = queue.poll();
            List<Integer> list = map.get(p);
            
            if(list!=null){
                for(int i : list){
                    indegree[i]--;

                    if(indegree[i]==0)
                        queue.add(i);
                }
            }
            
            
            res[idx]=p;
            idx++;
        }
        
        
        for(int i=0; i<indegree.length; i++){
              if(indegree[i]>0)
                  return new int[0];
        }
        
            
        return res;
        
        
        
        
    }
}