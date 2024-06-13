// https://leetcode.com/problems/minimum-number-of-refueling-stops

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        Arrays.sort(stations, (a,b)->a[0]-b[0]);

        int curr = startFuel;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        int cnt = 0 ;

        int idx =0;
        while(curr<target){

            while(idx<stations.length && stations[idx][0]<=curr){
                pq.offer(stations[idx][1]);
                idx++;
            }

            if(pq.isEmpty()) 
                return -1;

            curr += pq.poll();
            cnt++;

        }

        return cnt;

    }
}