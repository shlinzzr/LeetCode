// https://leetcode.com/problems/minimum-number-of-refueling-stops

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        // Arrays.sort(stations, (a,b)->a[0]-b[0]);

        int curr = startFuel;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        int cnt = 0 ;

        int idx =0;
        while(curr<target){

            while(idx<stations.length && curr>=stations[idx][0]){ // 如果目前的油 可以抵達幾個加油站, 通通放在pq內
                pq.offer(stations[idx][1]);
                idx++;
            }

            if(pq.isEmpty()) 
                return -1;

            curr += pq.poll(); // 加最大的油
            cnt++;

        }

        return cnt;

    }
}