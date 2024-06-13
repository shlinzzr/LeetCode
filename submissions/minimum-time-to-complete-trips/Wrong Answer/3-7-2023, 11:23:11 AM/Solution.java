// https://leetcode.com/problems/minimum-time-to-complete-trips

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b)-> Integer.compare(a[0]+a[1], b[0]+b[1])
        
        ); // st, cost
        
        for(int t : time){
            pq.offer(new int[]{0, t});
        }
        
        int curr=0;
        int trip = 0;
        while(trip<totalTrips){
            int[] p = pq.poll();
            trip+=p[1];
            curr=p[0]+p[1];
        }
        
        return curr;
    }
}