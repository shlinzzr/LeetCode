// https://leetcode.com/problems/ipo

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> (b[1]-b[2]) - (a[1]-a[2])
        );

        int res = 0 ;
        int len = profits.length;
        boolean[] done = new boolean[len];
        while(k-->0){

            for(int i=0; i<len; i++){
                if(done[i]) continue;

                if(capital[i]<=w){
                    done[i] = true;
                    pq.offer(new int[]{i, profits[i], capital[i]});
                }
            }

            if(pq.isEmpty()) break;

            int[] p = pq.poll();
            w = w+p[1];
            res+= p[2];
        }

        return w;

    }
}