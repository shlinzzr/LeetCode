// https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task

class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int len = logs.length;
        
        int startTime = 0;
        int max = 0;
        List<Integer> list = new ArrayList<>();
        
        
        for(int[] log : logs){
            
            int id= log[0];
            int leaveTime = log[1];
            
            int workTime = leaveTime - startTime;
            
            // System.out.println(id + " " + workTime);
            
            if(workTime >= max){
                
                if(workTime!=max){
                    list=new ArrayList<>();
                }
                
                max = workTime;
                list.add(id);
            }
            
            startTime = leaveTime;
        }
        
        Collections.sort(list);
        
        return list.get(0);
    }
}