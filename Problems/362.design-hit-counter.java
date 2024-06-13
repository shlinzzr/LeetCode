// https://leetcode.com/problems/design-hit-counter

class HitCounter {

    Queue<Integer> q ;
    public HitCounter() {
        q= new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        q.offer(timestamp);        
    }
    
    public int getHits(int timestamp) {
        while(!q.isEmpty() && q.peek()<=timestamp-300){
            q.poll();
        }
        
        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */