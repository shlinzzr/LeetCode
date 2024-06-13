// https://leetcode.com/problems/ipo

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int len = profits.length;

        PriorityQueue<int[]> task = new PriorityQueue<>( // idx, earn, capital
            (a, b) -> a[2]-b[2]
        );
         for(int i=0; i<len; i++){
            task.offer(new int[]{i, profits[i], capital[i]});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(
            // (a,b)-> (b[1]-b[2]) - (a[1]-a[2])
            (a,b) -> (b[1]-a[1])
        );
        
        while(k-->0){

            // for(int i=0; i<len; i++){
            //     if(done[i]) continue;

            //     if(capital[i]<=w){
            //         done[i] = true;
            //         pq.offer(new int[]{i, profits[i], capital[i]});
            //     }
            // }
            while(!task.isEmpty() && task.peek()[2]<=w){
                pq.offer(task.poll());
            }

            if(pq.isEmpty()) break;

            int[] p = pq.poll();
            w = w+p[1];
        }

        return w;

    }
}