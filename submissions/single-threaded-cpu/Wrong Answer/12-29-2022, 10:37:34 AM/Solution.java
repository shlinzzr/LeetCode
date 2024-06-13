// https://leetcode.com/problems/single-threaded-cpu

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        Map<int[], Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(tasks[i], i);
        }
        
        
        Arrays.sort(tasks, (a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a,b) -> a[1]==b[1]? a[0]-b[0] : a[1]-b[1]
        );
        
        int[] res = new int[n];
        int idx = 0;
        int curr=0;
        
        for(int i=0; i<n; i++){
            
            int[] t = tasks[i];
            pq.offer(t);
            
            
            while(i+1<n && tasks[i+1][0]==t[0]){
                i++;
                pq.offer(tasks[i]);
            }
            
            int[] p = pq.poll();
            curr+=p[1];
            
            while(i+1<n && tasks[i+1][0]<=curr){
                i++;
                pq.offer(tasks[i]);
            }
            
            
            res[idx] = map.get(p);
                  
            idx++;
        }
        
        while(!pq.isEmpty()){
            res[idx++] = map.get(pq.poll());
        }
        
        
        return res;
        
        
    }
}