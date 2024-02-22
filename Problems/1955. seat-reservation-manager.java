// https://leetcode.com/problems/seat-reservation-manager

class SeatManager {

    PriorityQueue<Integer> pq ;
    boolean[] arr;
    
    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        arr = new boolean[n]; 
        
        for(int i=1; i<=n; i++)
            pq.offer(i);
    
    }
    
    public int reserve() {
        int s = pq.poll();
        arr[s-1]=true;
        
        return s;
    }
    
    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
        arr[seatNumber-1]=false;
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */