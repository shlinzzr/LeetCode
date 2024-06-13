// https://leetcode.com/problems/campus-bikes-ii

class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        
        int wLen = workers.length;
        int bLen = bikes.length;

        boolean[] wseen = new boolean[wLen];
        boolean[] bseen = new boolean[bLen];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> a[0]-b[0]
        );

        for(int i=0; i<wLen ; i++){
            for(int j=0; j<bLen; j++){
                int[] w = workers[i];
                int[] b = bikes[j];
                pq.offer(new int[]{Math.abs(w[0]-b[0]) + Math.abs(w[1]-b[1]), i, j});
            }
        }

        int sum = 0;
        int cnt= 0;
        while(cnt < wLen){

            int[] p = pq.poll();
            if(wseen[p[1]] || bseen[p[2]])
                continue;

            System.out.println()

            wseen[p[1]]=true;
            bseen[p[2]]=true;

            sum += p[0];
            cnt++;

        }

        return sum;
    }
}