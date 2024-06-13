// https://leetcode.com/problems/course-schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indeg = new int[numCourses];
        
        
        for(int[] p : prereq){
            if(!map.containsKey(p[1])){
                map.put(p[1], new ArrayList<>());
            }
            map.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }
        
        
        boolean next = false;
        for(int in : indeg){
            if(in==0){
                next=true;
                break;
            }
        }  
        
        
        
        while(next){
            next=false;
            
            for(int i=0; i<numCourses; i++){
            
                if(indeg[i]==0){
                    List<Integer> list = map.get(i);
                    if(list!=null){
                        for(int nc : list){
                            indeg[nc]--;
                            if(indeg[nc]==0)
                                next=true;
                        }
                    }

                }
            }            
        }
        
        
        for(int in : indeg){
            if(in>0)
                return false;
        }        
        
        return true;

        
        
        
        
        
        
    }
}