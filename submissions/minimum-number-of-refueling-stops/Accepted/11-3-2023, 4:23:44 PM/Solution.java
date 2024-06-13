// https://leetcode.com/problems/minimum-number-of-refueling-stops

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int len = stations.length;

        // Arrays.sort(stations, (a,b)->a[0]-b[0]);
        //https://leetcode.com/problems/minimum-number-of-refueling-stops/solutions/294025/java-simple-code-greedy/

        if(startFuel >= target) 
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        int stop = 0;
        int max = startFuel;

        int i=0;
        while(max<target){
            while(i<len && max>=stations[i][0]){
                pq.offer(stations[i++][1]);
            }

            if(pq.isEmpty()) return -1;

            max += pq.poll();
            stop++;
        }


        return max>=target ? stop : -1;

    }
}