// https://leetcode.com/problems/course-schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indeg = new int[numCourses];
        
        
        for(int[] p : prereq){
            int need = p[1];
            int next = p[0];
            
            
            if(!map.containsKey(need)){
                map.put(need, new ArrayList<>());
            }
            map.get(need).add(next);
            indeg[next]++;
        }
        
        
        boolean nextRound = false;
        for(int in : indeg){
            if(in==0){
                nextRound=true;
                break;
            }
        }  
        
        
        
        while(nextRound){
            nextRound=false;
            
            for(int i=0; i<numCourses; i++){
            
                if(indeg[i]==0){
                    indeg[i]=-1;
                    // System.out.println("indeg["+i+"]=0");
                    List<Integer> list = map.get(i);
                    if(list!=null){
                        for(int nc : list){
                            indeg[nc]--;
                            if(indeg[nc]==0)
                                nextRound=true;
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