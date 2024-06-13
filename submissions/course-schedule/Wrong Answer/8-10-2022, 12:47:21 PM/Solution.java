// https://leetcode.com/problems/course-schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<numCourses; i++){
            map.put(i, i+1);
        }
        
        
        for(int i=0; i<prerequisites.length; i++){
            int[] req = prerequisites[i];
            int cur = req[0];
            int pre = req[1];
            
            map.put(pre, cur);
        }        
        
       
        int fast=0, slow=0;
        while(fast<numCourses-1){
            
            fast = map.get(fast);
            if(!map.containsKey(fast) && fast==numCourses-1)
                break;
            fast = map.get(fast);
            
            slow = map.get(slow);
            
             if(fast==slow)
                return false;
            
        }
        
        return true;
        
        
    }
}