// https://leetcode.com/problems/single-threaded-cpu

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        Map<int[], Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(tasks[i], i);
        }
        
        
        Arrays.sort(tasks, (a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
//         for(int[] t: tasks){
//             System.out.print("["+t[0]+ ","+t[1]+ "],");
//         }
        
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a,b) -> a[1]==b[1]? b[0]-a[0] : a[1]-b[1]
        );
        
        int[] res = new int[n];
        int idx = 0;
        int curr=tasks[0][0];
        
        for(int i=0; i<n; i++){
            
            int[] t = tasks[i];
            tasks[i][0] = i;
            pq.offer(t);
            
            
            while(i+1<n && (tasks[i+1][0]==t[0] || tasks[i+1][0]<=curr)){
                i++;
                tasks[i][0] = i;
                pq.offer(tasks[i]);
            }
            
            int[] p = pq.poll();
            curr+=p[1];
            System.out.println(curr);
            
//             while(i+1<n && tasks[i+1][0]<=curr){
//                 i++;
//                 pq.offer(tasks[i]);
//             }
            
            
            res[idx] = map.get(p);
                  
            idx++;
        }
        
        while(!pq.isEmpty()){
            
            int[] p = pq.poll();
             System.out.print("["+p[0]+ ","+p[1]+ "],");
            
            res[idx++] = map.get(p);
        }
        
        
        return res;
        /*
        [2,15]
        [16,9]
        [21,10]
        [37,4]
        
       [[19,13],[16,9],[21,10],[32,25],[37,4],[49,24],,[38,41],[37,34],[33,6],[45,4],[18,18],[46,39],[12,24]]
       
       [2,15], => 17  choose 6 
       [12,24],[16,9], => 26  choose 1
       [18,18],[19,13],[21,10], =>36 chopse 2
       [32,25],[33,6], => 42 choose 9
       [37,4],[37,34],[38,41], => 46 choose 4
       [45,4],[46,39],[49,24], => 50 choose 10
       
       
       
        */
        
    }
}