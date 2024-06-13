// https://leetcode.com/problems/minimum-time-to-complete-all-tasks

class Solution {
    public int findMinimumTime(int[][] tasks) {
        int[] slot= new int[2001];
        
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // slot, taskId;
        
        int total=0;
        for(int j=0; j<tasks.length; j++){
            int[] t = tasks[j];
            
            for(int i=t[0], i<=t[2]; i++){
                slot[i]++;
            }
            
            map.putIfAbsent(i, new ArrayList<>());
            map.get(i).add(j);
            
            total+= t[2];
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue(
            (a,b) -> b[1]-a[1]
        );
        
        for(int i=0; i<2001; i++){
            pq.offer(new int[]{i, slot[i]});
        }
        
        while(!pq.isEmpty() && total>0){
            
            int[] p = pq.poll();
            
            
            
            
            
        }
        
        
        
        
    }
}